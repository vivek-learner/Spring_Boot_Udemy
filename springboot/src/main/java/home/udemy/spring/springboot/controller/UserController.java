package home.udemy.spring.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import home.udemy.spring.springboot.exception.UserNotFoundException;
import home.udemy.spring.springboot.pojo.User;
import home.udemy.spring.springboot.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@GetMapping("/getUsers")
	private List<User> getUsers() {
		return iUserService.getUsers();
	}
	
	@GetMapping("/getUser/{id}")
	private User getUser(@PathVariable int id) throws UserNotFoundException {
		User user = iUserService.getUser(id);
		if(null != user) {
			return user;
		}else {
			throw new UserNotFoundException("User Not Found for id "+id);
		} 
	}
}
