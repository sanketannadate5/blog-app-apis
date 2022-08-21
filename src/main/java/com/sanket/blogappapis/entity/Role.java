package com.sanket.blogappapis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
//	roles are predefined in the DB
	@Id
	@Column(name = "role_id")
	private Long roleId;
	
	@Column(name = "role_name")
	private String name;
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
