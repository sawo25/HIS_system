package com.his.dtos;

import org.apache.ibatis.type.Alias;

@Alias(value="mediDto")
public class MediDto {
	
	private int medi_seq;
	private String job;
	private String name;
	private String dept;
	private String phone;
	public MediDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MediDto(int medi_seq, String job, String name, String dept, String phone) {
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
		return "MediDto [medi_seq=" + medi_seq + ", job=" + job + ", name=" + name + ", dept=" + dept + ", phone="
				+ phone + "]";
	}
	
	
}
