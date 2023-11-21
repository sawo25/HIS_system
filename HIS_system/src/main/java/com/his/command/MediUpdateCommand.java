package com.his.command;

import jakarta.validation.constraints.NotBlank;

public class MediUpdateCommand {

	private int medi_seq;
	
	@NotBlank(message = "부서를 입력하세요")
	private String dept;
	@NotBlank(message = "번호를 입력하세요")
	private String phone;
	
	public MediUpdateCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MediUpdateCommand(int medi_seq, @NotBlank(message = "부서를 입력하세요") String dept,
			@NotBlank(message = "번호를 입력하세요") String phone) {
		super();
		this.medi_seq = medi_seq;
		this.dept = dept;
		this.phone = phone;
	}
	public int getMedi_seq() {
		return medi_seq;
	}
	public void setMedi_seq(int medi_seq) {
		this.medi_seq = medi_seq;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "MediUpdateCommand [medi_seq=" + medi_seq + ", dept=" + dept + ", phone=" + phone + "]";
	}
	
	
}