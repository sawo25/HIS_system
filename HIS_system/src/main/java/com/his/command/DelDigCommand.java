package com.his.command;

import java.util.Arrays;

import jakarta.validation.constraints.NotEmpty;

public class DelDigCommand {
	
	@NotEmpty(message="삭제하려면 최소 하나 이상 체크하세요")
	private String[] dig_seq;

	public DelDigCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DelDigCommand(@NotEmpty(message = "삭제하려면 최소 하나 이상 체크하세요") String[] dig_seq) {
		super();
		this.dig_seq = dig_seq;
	}

	public String[] getDig_seq() {
		return dig_seq;
	}

	public void setDig_seq(String[] dig_seq) {
		this.dig_seq = dig_seq;
	}

	@Override
	public String toString() {
		return "DelDigCommand [dig_seq=" + Arrays.toString(dig_seq) + "]";
	}
	
	
}
