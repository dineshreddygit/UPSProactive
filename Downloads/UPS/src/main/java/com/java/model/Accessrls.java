
package com.java.model;

public class Accessrls {

	private String accessrl;

	public String getAccessrl() {
		return accessrl;
	}

	public void setAccessrl(String accessrl) {
		this.accessrl = accessrl;
	}

	public static Accessrls getInstance(String value) {
		Accessrls accessrls = new Accessrls();
		accessrls.setAccessrl(value);
		return accessrls;
	}

}
