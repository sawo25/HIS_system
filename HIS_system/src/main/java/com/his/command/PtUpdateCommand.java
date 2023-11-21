package com.his.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PtUpdateCommand {
	private int pt_seq;
	@NotNull(message = "담당 의료진을 선택하세요")
	private int medi_seq;
	@NotBlank(message = "부서를 입력하세요")
	private String dept;
	@NotNull(message = "신장을 입력하세요")
	private int height;
	@NotNull(message = "몸무게를 입력하세요")
	private int weight;
	@NotBlank(message = "질병을 입력하세요")
	private String diseas;
	public PtUpdateCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PtUpdateCommand(int pt_seq, @NotNull(message = "담당 의료진을 선택하세요") int medi_seq,
			@NotBlank(message = "부서를 입력하세요") String dept, @NotNull(message = "신장을 입력하세요") int height,
			@NotNull(message = "몸무게를 입력하세요") int weight, @NotBlank(message = "질병을 입력하세요") String diseas) {
		super();
		this.pt_seq = pt_seq;
		this.medi_seq = medi_seq;
		this.dept = dept;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
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
		return "PtUpdateCommand [pt_seq=" + pt_seq + ", medi_seq=" + medi_seq + ", dept=" + dept + ", height=" + height
				+ ", weight=" + weight + ", diseas=" + diseas + "]";
	}
	
	
}
