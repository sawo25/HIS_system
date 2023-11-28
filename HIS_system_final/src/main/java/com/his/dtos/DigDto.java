package com.his.dtos;

public class DigDto {

	private int dig_seq;
	
	private int pt_seq;
	
	private int medi_seq;
	
	private String diseas;
	
	private String content;
	
	private String dig_date;

	public DigDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DigDto(int dig_seq, int pt_seq, int medi_seq, String diseas, String content, String dig_date) {
		super();
		this.dig_seq = dig_seq;
		this.pt_seq = pt_seq;
		this.medi_seq = medi_seq;
		this.diseas = diseas;
		this.content = content;
		this.dig_date = dig_date;
	}

	public int getDig_seq() {
		return dig_seq;
	}

	public void setDig_seq(int dig_seq) {
		this.dig_seq = dig_seq;
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

	public String getDig_date() {
		return dig_date;
	}

	public void setDig_date(String dig_date) {
		this.dig_date = dig_date;
	}

	@Override
	public String toString() {
		return "DigDto [dig_seq=" + dig_seq + ", pt_seq=" + pt_seq + ", medi_seq=" + medi_seq + ", diseas=" + diseas
				+ ", content=" + content + ", dig_date=" + dig_date + "]";
	}
	
	
	
}
