
package com.java.model;

public class Chgtyps {

	private String chgtyp;

	public String getChgtyp() {
		return chgtyp;
	}

	public void setChgtyp(String chgtyp) {
		this.chgtyp = chgtyp;
	}

	public static Chgtyps getInstance(String value) {
		Chgtyps chgtyps = new Chgtyps();
		chgtyps.setChgtyp(value);
		return chgtyps;
	}

}
