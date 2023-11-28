package com.his.command;

import jakarta.validation.constraints.NotBlank;

public class LoginCommand {
	
	@NotBlank(message = "아이디를 입력해주세요")
	private String id;
	
	@NotBlank(message = "패스워드를 입력해주세요")
	private String password;
	
	@Override
	public String toString() {
		return "LoginCommand [id=" + id + ", password=" + password + "]";
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

	public LoginCommand(@NotBlank(message = "아이디를 입력해주세요") String id,
			@NotBlank(message = "패스워드를 입력해주세요")String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public LoginCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}



