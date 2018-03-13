
package com.java.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerProfile {

	private String cusid;
	private String grpid;
	private String pkgmvmind;
	private String hazmatind;
	private String dclval;
	private String dclccy;

	private String dowsun;
	private String dowmon;
	private String dowtue;
	private String dowwed;
	private String dowthu;
	private String dowfri;
	private String dowsat;
	private List<Accessrls> accessrls = new ArrayList<Accessrls>();
	private List<Chgtyps> chgtyps = new ArrayList<Chgtyps>();
	private List<Reffltr> reffltr = new ArrayList<Reffltr>();
	private List<Svctypes> svctypes = new ArrayList<Svctypes>();

	public String getCusid() {
		return cusid;
	}

	public void setCusid(String cusid) {
		this.cusid = cusid;
	}

	public String getGrpid() {
		return grpid;
	}

	public void setGrpid(String grpid) {
		this.grpid = grpid;
	}

	public String getPkgmvmind() {
		return pkgmvmind;
	}

	public void setPkgmvmind(String pkgmvmind) {
		this.pkgmvmind = pkgmvmind;
	}

	public String getHazmatind() {
		return hazmatind;
	}

	public void setHazmatind(String hazmatind) {
		this.hazmatind = hazmatind;
	}

	public String getDclval() {
		return dclval;
	}

	public void setDclval(String dclval) {
		this.dclval = dclval;
	}

	public String getDclccy() {
		return dclccy;
	}

	public void setDclccy(String dclccy) {
		this.dclccy = dclccy;
	}

	public String getDowsun() {
		return dowsun;
	}

	public void setDowsun(String dowsun) {
		this.dowsun = dowsun;
	}

	public String getDowmon() {
		return dowmon;
	}

	public void setDowmon(String dowmon) {
		this.dowmon = dowmon;
	}

	public String getDowtue() {
		return dowtue;
	}

	public void setDowtue(String dowtue) {
		this.dowtue = dowtue;
	}

	public String getDowwed() {
		return dowwed;
	}

	public void setDowwed(String dowwed) {
		this.dowwed = dowwed;
	}

	public String getDowthu() {
		return dowthu;
	}

	public void setDowthu(String dowthu) {
		this.dowthu = dowthu;
	}

	public String getDowfri() {
		return dowfri;
	}

	public void setDowfri(String dowfri) {
		this.dowfri = dowfri;
	}

	public String getDowsat() {
		return dowsat;
	}

	public void setDowsat(String dowsat) {
		this.dowsat = dowsat;
	}

	public List<Svctypes> getSvctypes() {
		return svctypes;
	}

	public void setSvctypes(List<Svctypes> svctypes) {
		this.svctypes = svctypes;
	}

	public List<Accessrls> getAccessrls() {
		return accessrls;
	}

	public void setAccessrls(List<Accessrls> accessrlsList) {
		this.accessrls = accessrlsList;
	}

	public List<Chgtyps> getChgtyps() {
		return chgtyps;
	}

	public void setChgtyps(List<Chgtyps> chgtyps) {
		this.chgtyps = chgtyps;
	}

	public List<Reffltr> getReffltr() {
		return reffltr;
	}

	public void setReffltr(List<Reffltr> reffltr) {
		this.reffltr = reffltr;
	}

}
