package com.his.dtos;

import org.apache.ibatis.type.Alias;

@Alias(value="adminDto")
public class AdminDto {

	private String id;
	private String password;
	
	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminDto(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminDto [id=" + id + ", password=" + password + "]";
	}
	
	
}
