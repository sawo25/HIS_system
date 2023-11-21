package com.his.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PtInsertCommand {
	
	private int pt_seq;
	
	@NotNull(message = "담당 의료진을 선택하세요")
	private int medi_seq;
	@NotBlank(message = "이름을 입력하세요")
	private String name;
	@NotBlank(message = "부서를 입력하세요")
	private String dept;
	@NotBlank(message = "성별을 선택하세요")
	private String sex;
	@NotNull(message = "신장을 입력하세요")
	private int height;
	@NotNull(message = "몸무게를 입력하세요")
	private int weight;
	@NotBlank(message = "질병을 입력하세요")
	private String diseas;
	public PtInsertCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PtInsertCommand(int pt_seq, @NotNull(message = "담당 의료진을 선택하세요") int medi_seq,
			@NotBlank(message = "이름을 입력하세요") String name, @NotBlank(message = "부서를 입력하세요") String dept,
			@NotBlank(message = "성별을 선택하세요") String sex, @NotNull(message = "신장을 입력하세요") int height,
			@NotNull(message = "몸무게를 입력하세요") int weight, @NotBlank(message = "질병을 입력하세요") String diseas) {
		super();
		this.pt_seq = pt_seq;
		this.medi_seq = medi_seq;
		this.name = name;
		this.dept = dept;
		this.sex = sex;
		this.height = height;
		this.weight = weight;
		this.diseas = diseas;
	}


	public int getPt_seq() {
		return pt_seq;
	}
	public void setPt_seq(int pt_seq) {
		this.pt_seq = pt_seq;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getDiseas() {
		return diseas;
	}
	public void setDiseas(String diseas) {
		this.diseas = diseas;
	}
	@Override
	public String toString() {
		return "PtInsertCommand [pt_seq=" + pt_seq + ", medi_seq=" + medi_seq + ", name=" + name + ", dept=" + dept
				+ ", sex=" + sex + ", height=" + height + ", weight=" + weight + ", diseas=" + diseas + "]";
	}
	
	
}
