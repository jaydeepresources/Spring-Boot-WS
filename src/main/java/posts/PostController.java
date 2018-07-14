package posts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.posts.Post;

import service.PostsDAOImpl;
import service.Status;

@RestController
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping("/posts")

public class PostController {

	PostsDAOImpl impl = new PostsDAOImpl();

	@RequestMapping("/all")
	public List<Post> getPosts() {

		ArrayList<Post> list = (ArrayList<Post>) impl.getPosts();
		return list;
	}

	@RequestMapping("/{title}")
	public List<Post> getPost(@PathVariable String title) {

		ArrayList<Post> list = (ArrayList<Post>) impl.getPost(title);
		return list;
	}

	@RequestMapping("/add")
	@PostMapping
	public Post addPost(@RequestBody Post post) {

		post = impl.addPost(post);
		return post;
	}

	@RequestMapping("/update/{id}")
	@PutMapping
	public Status updatePost(@PathVariable int id, @RequestBody Post post) {

		post.setId(id);
		Status s = impl.updatePost(post);

		return s;

	}

	@RequestMapping("/delete/{id}")
	@DeleteMapping
	public Status deletePost(@PathVariable("id") int id) {
		Post post = new Post();
		post.setId(id);
		Status s = impl.deletePost(post);
		return s;
	}
}
