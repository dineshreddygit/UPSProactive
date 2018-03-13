package com.java.exception;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus statusmsg;
	private int statuscd;

	public ApiError(int status, HttpStatus message) {
		super();
		this.statuscd = status;
		this.statusmsg = message;

	}

	public HttpStatus getStatusmsg() {
		return statusmsg;
	}

	public int getStatuscd() {
		return statuscd;
	}
}
