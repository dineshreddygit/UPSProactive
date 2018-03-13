package com.java.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.CustomerProfileRequest;
import com.java.model.CustomerProfileResponse;
import com.java.template.CustomerJDBCTemplate;

@RestController
public class CustomerRestController {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@RequestMapping(value = "/v1/shipments/customers/profile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomerProfileResponse customerDetails(
			@RequestBody CustomerProfileRequest customerProfileRequest) {
		CustomerJDBCTemplate customerJDBCTemplate = new CustomerJDBCTemplate();
		CustomerProfileResponse customeProfileResponse = customerJDBCTemplate
				.getCustomerDetails(customerProfileRequest);

		return customeProfileResponse;
	}

}
