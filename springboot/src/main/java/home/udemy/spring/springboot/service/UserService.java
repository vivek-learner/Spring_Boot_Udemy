package home.udemy.spring.springboot.service;

import java.util.*;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import home.udemy.spring.springboot.pojo.User;

@Service
public class UserService implements IUserService {

	private static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(1,"Parag",new Date()));
		users.add(new User(2,"Saurabh",new Date()));
		users.add(new User(3,"Reshma",new Date()));
	}
	
	@Override
	public List<User> getUsers() {
		return users;
	}

}