package home.udemy.spring.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import home.udemy.spring.springboot.pojo.User;
import home.udemy.spring.springboot.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return iUserService.getUsers();
	}
}
