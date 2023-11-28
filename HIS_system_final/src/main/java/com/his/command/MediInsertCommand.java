package com.his.command;

import jakarta.validation.constraints.NotBlank;

public class MediInsertCommand {

	private int medi_seq;
	
	@NotBlank(message = "항목을 선택하세요")
	private String job;
	@NotBlank(message = "이름을 입력하세요")
	private String name;
	
	@NotBlank(message = "부서를 입력하세요")
	private String dept;
	@NotBlank(message = "번호를 입력하세요")
	private String phone;
	public MediInsertCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MediInsertCommand(int medi_seq, @NotBlank(message = "항목을 선택하세요") String job,
			@NotBlank(message = "이름을 입력하세요") String name, @NotBlank(message = "부서를 입력하세요") String dept,
			@NotBlank(message = "번호를 입력하세요") String phone) {
		super();
		this.medi_seq = medi_seq;
		this.job = job;
		this.name = name;
		this.dept = dept;
		this.phone = phone;
	}
	public int getMedi_seq() {
		return medi_seq;
	}
	public void setMedi_seq(int medi_seq) {
		this.medi_seq = medi_seq;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "MediInsertCommand [medi_seq=" + medi_seq + ", job=" + job + ", name=" + name + ", dept=" + dept
				+ ", phone=" + phone + "]";
	}
	
	
	
	
}
