package org.posts;

//@Path("posts")

public class MyResource {

//	PostsDAOImpl impl = new PostsDAOImpl();
//
//	@Path("all")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Post> getPosts() {
//
//		ArrayList<Post> list = (ArrayList<Post>) impl.getPosts();
//
//		return list;
//	}
//
//	@Path("/{title}")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public ArrayList<Post> getPost(@PathParam("title") String title) {
//
//		ArrayList<Post> posts = impl.getPost(title);
//		
//		return posts;
//	}
//
//	@Path("/add")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Post addPost(Post post) {
//
//		post = impl.addPost(post);
//		System.out.println("Added Posts's Id: " + post.id);
//		return post;
//	}
//
//	@Path("update/{id}")
//	@PUT
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Status updatePost(@PathParam("id") int id, Post post) {
//
//		post.setId(id);
//		Status s = impl.updatePost(post);
//
//		return s;
//	}
//
//	@Path("delete/{id}")
//	@DELETE
//	@Produces(MediaType.APPLICATION_JSON)
//
//	public Status deletePost(@PathParam("id") int id) {		
//		Post post = new Post();
//		post.setId(id);
//		Status s = impl.deletePost(post);
//		return s;
//	}

}