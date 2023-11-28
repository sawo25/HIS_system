package com.his.command;

import jakarta.validation.constraints.NotBlank;

public class AdmUpdateCommand {

	private int adm_seq;
	
	@NotBlank(message = "처치 내용을 입력하세요")
	private String adm_content;
	@NotBlank(message = "투약 내용을 입력하세요")
	private String adm_fill;
	
	public AdmUpdateCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdmUpdateCommand(int adm_seq, @NotBlank(message = "처치 내용을 입력하세요") String adm_content,
			@NotBlank(message = "투약 내용을 입력하세요") String adm_fill) {
		super();
		this.adm_seq = adm_seq;
		this.adm_content = adm_content;
		this.adm_fill = adm_fill;
	}
	public int getAdm_seq() {
		return adm_seq;
	}
	public void setAdm_seq(int adm_seq) {
		this.adm_seq = adm_seq;
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
		return "AdmUpdateCommand [adm_seq=" + adm_seq + ", adm_content=" + adm_content + ", adm_fill=" + adm_fill + "]";
	}
	
	
}
