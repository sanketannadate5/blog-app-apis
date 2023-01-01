package com.sanket.blogappapis.payloads;

import java.util.HashSet;
import java.util.Set;

import com.sanket.blogappapis.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {

	private Long id;
	
	@NotEmpty
	@Size(min = 3, message = "Name should be minimum of 3 character !!")
	private String name;
	
	@NotEmpty
	@Email(message = "Email Address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min = 8, max = 16, message = "password should be between 8 to 16 character !!")
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<Role> roles = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
