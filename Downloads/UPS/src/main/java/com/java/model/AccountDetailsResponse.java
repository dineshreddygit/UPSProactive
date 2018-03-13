package com.java.model;

import java.util.ArrayList;
import java.util.List;

public class AccountDetailsResponse {

	private List<ValidAccountDetails> validaccountDetails = new ArrayList<ValidAccountDetails>();
	private List<InvalidAccountDetails> invalidaccountDetails = new ArrayList<InvalidAccountDetails>();
	private String errorCode;
	private String errorText;
	private String sqlCode;

	public List<ValidAccountDetails> getValidaccountDetails() {
		return validaccountDetails;
	}

	public void setValidaccountDetails(List<ValidAccountDetails> validaccountDetails) {
		this.validaccountDetails = validaccountDetails;
	}

	public List<InvalidAccountDetails> getInvalidaccountDetails() {
		return invalidaccountDetails;
	}

	public void setInvalidaccountDetails(List<InvalidAccountDetails> invalidaccountDetails) {
		this.invalidaccountDetails = invalidaccountDetails;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public String getSqlCode() {
		return sqlCode;
	}

	public void setSqlCode(String sqlCode) {
		this.sqlCode = sqlCode;
	}

}
