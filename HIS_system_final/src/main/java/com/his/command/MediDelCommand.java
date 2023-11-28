package com.his.command;

public class MediDelCommand {

	private int medi_seq;

	public MediDelCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MediDelCommand(int medi_seq) {
		super();
		this.medi_seq = medi_seq;
	}

	public int getMedi_seq() {
		return medi_seq;
	}

	public void setMedi_seq(int medi_seq) {
		this.medi_seq = medi_seq;
	}

	@Override
	public String toString() {
		return "MediDelCommand [medi_seq=" + medi_seq + "]";
	}
	
	
}
