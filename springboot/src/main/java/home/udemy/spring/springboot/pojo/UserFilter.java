package home.udemy.spring.springboot.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("UserFilter")
public class UserFilter {
	
	private int id;
	private String name;
	private Date dob;
	
	public UserFilter(int id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "UserFilter [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
}
