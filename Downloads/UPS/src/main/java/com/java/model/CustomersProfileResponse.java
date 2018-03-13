package com.java.model;

import java.util.ArrayList;
import java.util.List;

public class CustomersProfileResponse {

	private String returnParam;
	private String errorCode;
	private String errorText;
	private String sqlCode;
	private List<ResultSetOut> resultSetOut = new ArrayList<ResultSetOut>();

	public String getReturnParam() {
		return returnParam;
	}

	public void setReturnParam(String returnParam) {
		this.returnParam = returnParam;
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

	public List<ResultSetOut> getResultSetOut() {
		return resultSetOut;
	}

	public void setResultSetOut(List<ResultSetOut> resultSetOut) {
		this.resultSetOut = resultSetOut;
	}

 
}
