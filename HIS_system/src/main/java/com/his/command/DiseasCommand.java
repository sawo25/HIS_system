package com.his.command;

public class DiseasCommand {

	private String diseas;

	public DiseasCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiseasCommand(String diseas) {
		super();
		this.diseas = diseas;
	}

	public String getDiseas() {
		return diseas;
	}

	public void setDiseas(String diseas) {
		this.diseas = diseas;
	}

	@Override
	public String toString() {
		return "DiseasCommand [diseas=" + diseas + "]";
	}
	
	
}
