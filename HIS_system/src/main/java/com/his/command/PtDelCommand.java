package com.his.command;

public class PtDelCommand {

	private int pt_seq;

	public PtDelCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PtDelCommand(int pt_seq) {
		super();
		this.pt_seq = pt_seq;
	}

	public int getPt_seq() {
		return pt_seq;
	}

	public void setPt_seq(int pt_seq) {
		this.pt_seq = pt_seq;
	}

	@Override
	public String toString() {
		return "PtDelCommand [pt_seq=" + pt_seq + "]";
	}
	
}
