package com.his.dtos;

import org.apache.ibatis.type.Alias;

@Alias(value="ptDto")
public class PtDto {

	private int pt_seq;
	private int medi_seq;
	private String name;
	private String dept;
	private String sex;
	private int height;
	private int weight;
	private String diseas;
	public PtDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PtDto(int pt_seq, int medi_seq, String name, String dept, String sex, int height, int weight,
			String diseas) {
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
		return "PtDto [pt_seq=" + pt_seq + ", medi_seq=" + medi_seq + ", name=" + name + ", dept=" + dept + ", sex="
				+ sex + ", height=" + height + ", weight=" + weight + ", diseas=" + diseas + "]";
	}
	
	
}
