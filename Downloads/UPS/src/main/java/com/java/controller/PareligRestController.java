package com.java.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.exception.DataNotFoundException;
import com.java.exception.ErrorMessage;
import com.java.model.PAREligRequest;
import com.java.model.PAREligResponse;
import com.java.template.PAREligJDBCTemplate;

@RestController
public class PareligRestController {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@RequestMapping(value = "/v1/shipments/par/eligibility", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity pareligDetails(
			@RequestBody String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		PAREligRequest pareligRequest;
		try {
			pareligRequest = mapper.readValue(jsonString, PAREligRequest.class);
		} catch (IOException e1) {
			return new ResponseEntity<String>("{\"error\":\"Request is Invalid\"}", HttpStatus.BAD_REQUEST) ;
		}
		PAREligResponse pareligResponse = null;
		try {
			pareligResponse = new PAREligResponse();
			
			PAREligJDBCTemplate pareligJDBCTemplate = new PAREligJDBCTemplate();
			pareligResponse = pareligJDBCTemplate.getPARElig(pareligRequest);
			return new ResponseEntity<PAREligResponse>(pareligResponse, HttpStatus.OK);
		} catch (NullPointerException e) {
			System.out.println("null pointer");
			pareligResponse.setStatuscd("No result found");
			return new ResponseEntity<PAREligResponse>(pareligResponse, HttpStatus.NOT_FOUND);
		} catch (SQLException e) {
			System.out.println("Sql");
			return new ResponseEntity<PAREligResponse>(pareligResponse, HttpStatus.BAD_REQUEST);
		}
	}

	

}
