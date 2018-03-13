
package com.java.model;

public class Svctypes {

	private String svctyp;

	public String getSvctyp() {
		return svctyp;
	}

	public void setSvctyp(String svctyp) {
		this.svctyp = svctyp;
	}

	public static Svctypes getInstance(String value) {
		Svctypes svcTypes = new Svctypes();
		svcTypes.setSvctyp(value);
		return svcTypes;
	}

}
