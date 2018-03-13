
package com.java.model;

public class Reffltr {

	private String reftyp;
	private String refcri;
	private String reftxt;

	public static Reffltr getInstance(String typ, String cri, String txt) {
		Reffltr reffltr = new Reffltr();
		reffltr.setRefcri(cri);
		reffltr.setReftxt(txt);
		reffltr.setReftyp(typ);
		return reffltr;
	}

	public String getReftyp() {
		return reftyp;
	}

	public void setReftyp(String reftyp) {
		this.reftyp = reftyp;
	}

	public String getRefcri() {
		return refcri;
	}

	public void setRefcri(String refcri) {
		this.refcri = refcri;
	}

	public String getReftxt() {
		return reftxt;
	}

	public void setReftxt(String reftxt) {
		this.reftxt = reftxt;
	}

}
