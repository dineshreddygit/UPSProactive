
package com.java.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerProfileResponse  {

	private String statuscd;
	private List<CustomerAct> customerAct = new ArrayList<CustomerAct>();
	private List<CustomerProfile> customerProfile = new ArrayList<CustomerProfile>();

	public String getStatuscd() {
		return statuscd;
	}

	public void setStatuscd(String statuscd) {
		this.statuscd = statuscd;
	}

	public List<CustomerAct> getCustomerAct() {
		return customerAct;
	}

	public void setCustomerAct(List<CustomerAct> customerAct) {
		this.customerAct = customerAct;
	}

	public List<CustomerProfile> getCustomerProfile() {
		return customerProfile;
	}

	public void setCustomerProfile(List<CustomerProfile> customerProfile1) {
		this.customerProfile = customerProfile1;
	}

}
