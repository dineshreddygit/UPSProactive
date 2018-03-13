package com.java.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.CustomersProfileResponse;
import com.java.template.CustomersProfileTemplate;

@RestController
public class CustomerProfiles {

	@RequestMapping(value = "/customersprofile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomersProfileResponse customersDetails() {
		CustomersProfileTemplate customersProfileTemplate = new CustomersProfileTemplate();
		CustomersProfileResponse customersProfileResponse = customersProfileTemplate.getCustomerDetails();

		return customersProfileResponse;
	}

}
