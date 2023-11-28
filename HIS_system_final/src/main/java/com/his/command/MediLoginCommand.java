package com.his.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MediLoginCommand {

	@NotNull(message = "의료진 번호를 입력하세요")
	private int medi_seq;
	@NotBlank(message = "이름을 입력하세요")
	private String name;
	public MediLoginCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MediLoginCommand(@NotNull(message = "의료진 번호를 입력하세요") int medi_seq,
			@NotBlank(message = "이름을 입력하세요") String name) {
		super();
		this.medi_seq = medi_seq;
		this.name = name;
	}
	public int getMedi_seq() {
		return medi_seq;
	}
	public void setMedi_seq(int medi_seq) {
		this.medi_seq = medi_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MediLoginCommand [medi_seq=" + medi_seq + ", name=" + name + "]";
	}
	
	
}
