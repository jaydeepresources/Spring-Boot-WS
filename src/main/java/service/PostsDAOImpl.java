package service;

import java.util.ArrayList;
import java.util.List;

import com.posts.Post;

import model.PostQueries;

public class PostsDAOImpl implements PostsDAO {

	PostQueries queries = new PostQueries();
	
	@Override
	public List<Post> getPosts() {

		List<Post> posts = queries.view();
		
		return posts;
	}

	@Override
	public ArrayList<Post> getPost(String title) {
		ArrayList<Post> posts = queries.view(title);
		return posts;
	}

	@Override
	public Post addPost(Post post) {
		
		post = queries.insert(post);

		return post;
	}
	
	@Override
	public Status updatePost(Post post) {
		
		Status s = new Status();
		
		boolean flag = queries.update(post);
		
		s.setQueryStatus(flag);
		
		return s;

	}

	@Override
	public Status deletePost(Post post) {

		Status s = new Status();
		
		boolean flag = queries.delete(post);
		
		s.setQueryStatus(flag);
		
		return s;

	}

}
