package com.his.command;

import jakarta.validation.constraints.NotBlank;

public class UpdateDigCommand {
	
	private int dig_seq;
	
	@NotBlank(message = "병명을 입력하세요")
	private String diseas;
	@NotBlank(message = "진료 내용을 입력하세요")
	private String content;
	
	public UpdateDigCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateDigCommand(int dig_seq, @NotBlank(message = "병명을 입력하세요") String diseas,
			@NotBlank(message = "진료 내용을 입력하세요") String content) {
		super();
		this.dig_seq = dig_seq;
		this.diseas = diseas;
		this.content = content;
	}

	public int getDig_seq() {
		return dig_seq;
	}

	public void setDig_seq(int dig_seq) {
		this.dig_seq = dig_seq;
	}

	public String getDiseas() {
		return diseas;
	}

	public void setDiseas(String diseas) {
		this.diseas = diseas;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "UpdateDigCommand [dig_seq=" + dig_seq + ", diseas=" + diseas + ", content=" + content + "]";
	}

}
