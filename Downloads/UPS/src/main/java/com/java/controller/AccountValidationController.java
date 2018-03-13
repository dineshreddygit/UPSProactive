package com.java.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.AccountDetailsRequest;
import com.java.model.AccountDetailsResponse;
import com.java.template.AccountDetailsTemplate;

@RestController
public class AccountValidationController {

	@RequestMapping(value = "/accountsvalidation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AccountDetailsResponse accountDetails(
			@RequestBody AccountDetailsRequest accountDetailsRequest) {
		System.out.println("Hello");
		AccountDetailsTemplate accountDetailsTemplate = new AccountDetailsTemplate();
		AccountDetailsResponse accountDetailsResponse = accountDetailsTemplate.getAccountDetails(accountDetailsRequest);

		return accountDetailsResponse;
	}

}
