package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.posts.Post;

public class PostQueries {

	private String sql;

	private static Connection con;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/test",
					"root", "admin1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PostQueries() {

	}

	public Post insert(Post post) {
		sql = "insert into posts (title,body) values (?,?)";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, post.getTitle());
			pst.setString(2, post.getBody());

			int res = pst.executeUpdate();

			if (res == 1) {
				sql = "select * from posts where title = ?";
				pst = con.prepareStatement(sql);			
				pst.setString(1, post.getTitle());
				ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {					
					post = new Post(rs.getInt(1), rs.getString(2), rs.getString(3));
					
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return post;
	}

	public List<Post> view() {

		sql = "select * from posts";

		ArrayList<Post> posts = new ArrayList<>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				posts.add(new Post(rs.getInt(1), rs.getString(2), rs
						.getString(3)));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return posts;
	}

	public boolean update(Post post) {
		sql = "update posts set title = ?, body = ? where id = ?";
		boolean queryStatus = false;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, post.getTitle());
			pst.setString(2, post.getBody());
			pst.setInt(3, post.getId());

			int res = pst.executeUpdate();

			queryStatus = (res == 1) ? true : false;
			System.out.println("Post Updated? = " + queryStatus);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return queryStatus;

	}

	public boolean delete(Post post) {
		sql = "delete from posts where id = ?";
		boolean queryStatus = false;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, post.getId());

			int res = pst.executeUpdate();

			queryStatus = (res == 1) ? true : false;
			System.out.println("Post Deleted? = " + queryStatus);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return queryStatus;

	}

	public ArrayList<Post> view(String title) {
		ArrayList<Post> list = new ArrayList<Post>();
		sql = "select * from posts where title like ?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%" + title + "%");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

}
