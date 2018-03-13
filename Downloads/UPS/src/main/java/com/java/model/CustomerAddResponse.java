package com.java.model;

public class CustomerAddResponse {

	private String errorCode;
	private String errorText;
	private String sqlCode;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String erroText) {
		this.errorText = erroText;
	}
	public String getSqlCode() {
		return sqlCode;
	}
	public void setSqlCode(String sqlCode) {
		this.sqlCode = sqlCode;
	}
	
}
