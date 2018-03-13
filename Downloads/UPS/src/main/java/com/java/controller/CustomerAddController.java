package com.java.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.AccountDetailsRequest;
import com.java.model.AccountDetailsResponse;
import com.java.model.CustomerAddRequest;
import com.java.model.CustomerAddResponse;
import com.java.template.AccountDetailsTemplate;
import com.java.template.CustomerAddTemplate;

@RestController
public class CustomerAddController {

	@RequestMapping(value = "/customeradd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomerAddResponse customerAddResponse(@RequestBody CustomerAddRequest customerAddRequest) {
		System.out.println("Request");
		CustomerAddTemplate customerAddTemplate = new CustomerAddTemplate();
		CustomerAddResponse customeraddResponse = customerAddTemplate.customerAdd(customerAddRequest);

		return customeraddResponse;
	}
}
