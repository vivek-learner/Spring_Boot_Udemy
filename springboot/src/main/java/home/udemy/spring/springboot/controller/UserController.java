package home.udemy.spring.springboot.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import home.udemy.spring.springboot.exception.UserNotFoundException;
import home.udemy.spring.springboot.pojo.User;
import home.udemy.spring.springboot.pojo.UserFilter;
import home.udemy.spring.springboot.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@GetMapping("/getUsers")
	protected List<User> getUsers() {
		return iUserService.getUsers();
	}
	
	@GetMapping("/getUser/{id}")
	private EntityModel<User> getUser(@PathVariable int id) throws UserNotFoundException {
		
		User user = iUserService.getUser(id);
		if(null == user) {
			throw new UserNotFoundException("User Not Found for id "+id);
		}
		
		EntityModel<User> resource = EntityModel.of(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@GetMapping("/getUserIdName")
	private MappingJacksonValue getUserIdName() {
		UserFilter  userFilter = new UserFilter(1,"Ankita",new Date());
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter",filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(userFilter);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/getUserIdDob")
	private MappingJacksonValue getUserIdDob() {
		
		UserFilter userFilter= new UserFilter(1,"Arpa",new Date());
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("id","dob");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(userFilter);
		mapping.setFilters(filters);
		return mapping;
	}
}
