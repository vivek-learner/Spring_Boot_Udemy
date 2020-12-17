package home.udemy.spring.springboot.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import home.udemy.spring.springboot.exception.UserNotFoundException;
import home.udemy.spring.springboot.pojo.Post;
import home.udemy.spring.springboot.pojo.User;
import home.udemy.spring.springboot.repository.IPostRepository;
import home.udemy.spring.springboot.repository.IUserRepository;
import home.udemy.spring.springboot.service.IUserService;

@RestController
public class UserControllerJpa {
		
	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private IPostRepository iPostRepository;
	
	@GetMapping("/jpa/getUsers")
	protected List<User> getUsers() {
		return iUserRepository.findAll();
	}
	
	@GetMapping("/jpa/getUser/{id}")
	private EntityModel<User> getUser(@PathVariable int id) throws UserNotFoundException {
		
		Optional<User> user = iUserRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User Not Found for id "+id);
		}
		
		EntityModel<User> resource = EntityModel.of(user.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@GetMapping("/jpa/getPosts/{id}/posts")
	private List<Post> getPosts(@PathVariable int id) throws UserNotFoundException {
		
		Optional<User> user = iUserRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User Not Found for id "+id);
		}
		return user.get().getPost();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/jpa/creatPost/{id}/posts")
	private void creatPosts(@PathVariable int id,@RequestBody Post post) throws UserNotFoundException {
		
		Optional<User> userOptional = iUserRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found for id "+id);
		}
		User user = userOptional.get();
		post.setUser(user);
		iPostRepository.save(post);

	}
}
