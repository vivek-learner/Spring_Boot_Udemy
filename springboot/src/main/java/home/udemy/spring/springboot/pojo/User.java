package home.udemy.spring.springboot.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	
	private int id;
	private String name;
	private Date dob;
	
	@JsonIgnore
	private String passport;
	
	
	public User() {
		
	}
	
	public User(int id, String name, Date dob) {
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
	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", passport=" + passport + "]";
	}
	
}
