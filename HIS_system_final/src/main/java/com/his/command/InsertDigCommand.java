package com.his.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InsertDigCommand {
	
	private int dig_seq;
	
	@NotNull(message = "진료할 환자를 선택하세요")
	private int pt_seq;
	@NotNull(message = "진료한 의료진을 선택하세요")
	private int medi_seq;
	@NotBlank(message = "질병을 입력하세요")
	private String diseas;
	@NotBlank(message = "진료 내용을 입력하세요")
	private String content;

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
	
	public InsertDigCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InsertDigCommand(int dig_seq, @NotNull(message = "진료할 환자를 선택하세요") int pt_seq,
			@NotNull(message = "진료한 의료진을 선택하세요") int medi_seq, @NotBlank(message = "질병을 입력하세요") String diseas,
			@NotBlank(message = "진료 내용을 입력하세요") String content, @NotNull(message = "년도를 입력하세요.") int year,
			@NotNull(message = "달을 입력하세요.") int month, @NotNull(message = "날짜를 입력하세요.") int date,
			@NotNull(message = "시간를 입력하세요.") int hour, @NotNull(message = "분을 입력하세요.") int min) {
		super();
		this.dig_seq = dig_seq;
		this.pt_seq = pt_seq;
		this.medi_seq = medi_seq;
		this.diseas = diseas;
		this.content = content;
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.min = min;
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
	@Override
	public String toString() {
		return "InsertDigCommand [dig_seq=" + dig_seq + ", pt_seq=" + pt_seq + ", medi_seq=" + medi_seq + ", diseas="
				+ diseas + ", content=" + content + ", year=" + year + ", month=" + month + ", date=" + date + ", hour="
				+ hour + ", min=" + min + "]";
	}
	
}
