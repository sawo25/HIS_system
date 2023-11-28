package com.his.dtos;

public class AdmDto {
	
	private int adm_seq;
	private int adm_pt;
	private int adm_rn;
	private String adm_date;
	private String adm_content;
	private String adm_fill;
	
	public AdmDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdmDto(int adm_seq, int adm_pt, int adm_rn, String adm_date, String adm_content, String adm_fill) {
		super();
		this.adm_seq = adm_seq;
		this.adm_pt = adm_pt;
		this.adm_rn = adm_rn;
		this.adm_date = adm_date;
		this.adm_content = adm_content;
		this.adm_fill = adm_fill;
	}

	public int getAdm_seq() {
		return adm_seq;
	}

	public void setAdm_seq(int adm_seq) {
		this.adm_seq = adm_seq;
	}

	public int getAdm_pt() {
		return adm_pt;
	}

	public void setAdm_pt(int adm_pt) {
		this.adm_pt = adm_pt;
	}

	public int getAdm_rn() {
		return adm_rn;
	}

	public void setAdm_rn(int adm_rn) {
		this.adm_rn = adm_rn;
	}

	public String getAdm_date() {
		return adm_date;
	}

	public void setAdm_date(String adm_date) {
		this.adm_date = adm_date;
	}

	public String getAdm_content() {
		return adm_content;
	}

	public void setAdm_content(String adm_content) {
		this.adm_content = adm_content;
	}

	public String getAdm_fill() {
		return adm_fill;
	}

	public void setAdm_fill(String adm_fill) {
		this.adm_fill = adm_fill;
	}

	@Override
	public String toString() {
		return "AdmDto [adm_seq=" + adm_seq + ", adm_pt=" + adm_pt + ", adm_rn=" + adm_rn + ", adm_date=" + adm_date
				+ ", adm_content=" + adm_content + ", adm_fill=" + adm_fill + "]";
	}
	
	
}
