package com.premsh.visitorsure.models;


public class Role {
	
	private Integer roleId;
	private String roleName;
	private String discription;
	
	
	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String description) {
		this.discription = description;
	}


	@Override
	public String toString() {
		return roleId+" | "+roleName + " : "+ discription;
	}
	
	
}
