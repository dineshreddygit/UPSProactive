package com.java.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=false)
public class PAREligRequest {
	
	private String datasrc;
	private String shipperact;
	private String thirdpartyact;
	private String freightact;
	private String consbilact;
	private String pudate;
	private String smtref1;
	private String smtref2;
	private String sdclval;
	private String sdclccy;
	private String svctyp;
	private String smtchrgetyp;
	private String smtaccessrl;
	private String trknum;
	private String pdclval;
	private String pdclccy;
	private String hazmat;
	private String pkgref1;
	private String pkgref2;
	private String pkgref3;
	private String pkgref4;
	private String pkgref5;
	private String pkgaccessrl;

	public String getDatasrc() {
		return datasrc;
	}

	public void setDatasrc(String datasrc) {
		this.datasrc = datasrc;
	}

	public String getShipperact() {
		return shipperact;
	}

	public void setShipperact(String shipperact) {
		this.shipperact = shipperact;
	}

	public String getThirdpartyact() {
		return thirdpartyact;
	}

	public void setThirdpartyact(String thirdpartyact) {
		this.thirdpartyact = thirdpartyact;
	}

	public String getFreightact() {
		return freightact;
	}

	public void setFreightact(String freightact) {
		this.freightact = freightact;
	}

	public String getConsbilact() {
		return consbilact;
	}

	public void setConsbilact(String consbilact) {
		this.consbilact = consbilact;
	}

	public String getPudate() {
		return pudate;
	}

	public void setPudate(String pudate) {
		this.pudate = pudate;
	}

	public String getSmtref1() {
		return smtref1;
	}

	public void setSmtref1(String smtref1) {
		this.smtref1 = smtref1;
	}

	public String getSmtref2() {
		return smtref2;
	}

	public void setSmtref2(String smtref2) {
		this.smtref2 = smtref2;
	}

	public String getSdclval() {
		return sdclval;
	}

	public void setDclamt(String dclamt) {
		this.sdclval = sdclval;
	}

	public String getSdclccy() {
		return sdclccy;
	}

	public void setSdclccy(String sdclccy) {
		this.sdclccy = sdclccy;
	}

	public String getSvctyp() {
		return svctyp;
	}

	public void setSvctyp(String svctyp) {
		this.svctyp = svctyp;
	}

	public String getSmtchrgetyp() {
		return smtchrgetyp;
	}

	public void setSmtchrgetyp(String smtchrgetyp) {
		this.smtchrgetyp = smtchrgetyp;
	}

	public String getSmtaccessrl() {
		return smtaccessrl;
	}

	public void setSmtaccessrl(String smtaccessrl) {
		this.smtaccessrl = smtaccessrl;
	}

	public String getPkgaccessrl() {
		return pkgaccessrl;
	}

	public void setPkgaccessrl(String pkgaccessrl) {
		this.pkgaccessrl = pkgaccessrl;
	}

	public String getTrknum() {
		return trknum;
	}

	public void setTrknum(String trknum) {
		this.trknum = trknum;
	}

	public String getPdclval() {
		return pdclval;
	}

	public void setPdclval(String pdclval) {
		this.pdclval = pdclval;
	}

	public String getPdclccy() {
		return pdclccy;
	}

	public void setPdclccy(String pdclccy) {
		this.pdclccy = pdclccy;
	}

	public String getHazmat() {
		return hazmat;
	}

	public void setHazmat(String hazmat) {
		this.hazmat = hazmat;
	}

	public String getPkgref1() {
		return pkgref1;
	}

	public void setPkgref1(String pkgref1) {
		this.pkgref1 = pkgref1;
	}

	public String getPkgref2() {
		return pkgref2;
	}

	public void setPkgref2(String pkgref2) {
		this.pkgref2 = pkgref2;
	}

	public String getPkgref3() {
		return pkgref3;
	}

	public void setPkgref3(String pkgref3) {
		this.pkgref3 = pkgref3;
	}

	public String getPkgref4() {
		return pkgref4;
	}

	public void setPkgref4(String pkgref4) {
		this.pkgref4 = pkgref4;
	}

	public String getPkgref5() {
		return pkgref5;
	}

	public void setPkgref5(String pkgref5) {
		this.pkgref5 = pkgref5;
	}

	@Override
	public String toString() {
		return "PAREligRequest [shipperact=" + shipperact + ", thirdpartyact=" + thirdpartyact + ", freightact="
				+ freightact + ", consbilact=" + consbilact + ", pudate=" + pudate + ", smtref1=" + smtref1
				+ ", smtref2=" + smtref2 + ",  sdclccy=" + sdclccy + ", svctyp=" + svctyp + ", smtchrgetyp="
				+ smtchrgetyp + ", trknum=" + trknum + ", pdclval=" + pdclval + ", pdclccy=" + pdclccy + ", hazmat="
				+ hazmat + ", pkgref1=" + pkgref1 + ", pkgref2=" + pkgref2 + ", pkgref3=" + pkgref3 + ", pkgref4="
				+ pkgref4 + ", pkgref5=" + pkgref5 + ", pkgaccessrl=" + pkgaccessrl + "]";
	}

}
