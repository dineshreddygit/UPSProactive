package com.java.model;

public class PAREligResponse {
	private String statuscd;
	private String reqtrknum;
	private String parind;

	public PAREligResponse() {
	}

	public PAREligResponse(String statuscd) {
		super();
		this.statuscd = statuscd;
	}

	public String getStatuscd() {
		return statuscd;
	}

	public void setStatuscd(String statuscd) {
		this.statuscd = statuscd;
	}

	public String getReqtrknum() {
		return reqtrknum;
	}

	public void setReqtrknum(String reqtrknum) {
		this.reqtrknum = reqtrknum;
	}

	public String getParind() {
		return parind;
	}

	public void setParind(String parind) {
		this.parind = parind;
	}

	/*
	 * @Override public String toString() { return "PAREligResponse [statuscd=" +
	 * statuscd + ", statusmsg=" + statusmsg + ", reqtrknum=" + reqtrknum +
	 * ", parind=" + parind + "]"; }
	 */

}
