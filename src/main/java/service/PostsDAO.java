package service;

import java.util.List;

import com.posts.Post;

public interface PostsDAO {

	List<Post> getPosts();

	List<Post> getPost(String title);

	Post addPost(Post post);

	Status updatePost(Post post);

	Status deletePost(Post post);

}
