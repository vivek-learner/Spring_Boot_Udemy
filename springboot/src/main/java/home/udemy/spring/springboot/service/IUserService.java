package home.udemy.spring.springboot.service;

import java.util.List;

import home.udemy.spring.springboot.pojo.User;

public interface IUserService {

	List<User> getUsers();

	User getUser(int id);

}
