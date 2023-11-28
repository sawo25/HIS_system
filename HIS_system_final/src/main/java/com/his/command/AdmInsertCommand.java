package com.his.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AdmInsertCommand {

	private int adm_seq;
	
	private int adm_pt;
	private int adm_rn;

	// dig_date
	@NotNull(message = "년도를 입력하세요.")
	private int year;
	@NotNull(message = "달을 입력하세요.")
	private int month;
	@NotNull(message = "날짜를 입력하세요.")
	private int date;
	@NotNull(message = "시간를 입력하세요.")
	private int hour;
	@NotNull(message = "분을 입력하세요.")
	private int min;
		
	
	@NotBlank(message = "처치 내용을 입력하세요")
	private String adm_content;
	@NotBlank(message = "투약 내용을 입력하세요")
	private String adm_fill;
	public AdmInsertCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdmInsertCommand(int adm_seq, int adm_pt, int adm_rn, @NotNull(message = "년도를 입력하세요.") int year,
			@NotNull(message = "달을 입력하세요.") int month, @NotNull(message = "날짜를 입력하세요.") int date,
			@NotNull(message = "시간를 입력하세요.") int hour, @NotNull(message = "분을 입력하세요.") int min,
			@NotBlank(message = "처치 내용을 입력하세요") String adm_content,
			@NotBlank(message = "투약 내용을 입력하세요") String adm_fill) {
		super();
		this.adm_seq = adm_seq;
		this.adm_pt = adm_pt;
		this.adm_rn = adm_rn;
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.min = min;
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
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
		return "AdmInsertCommand [adm_seq=" + adm_seq + ", adm_pt=" + adm_pt + ", adm_rn=" + adm_rn + ", year=" + year
				+ ", month=" + month + ", date=" + date + ", hour=" + hour + ", min=" + min + ", adm_content="
				+ adm_content + ", adm_fill=" + adm_fill + "]";
	}
	
	
	
}
