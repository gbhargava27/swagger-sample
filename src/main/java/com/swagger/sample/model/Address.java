package com.swagger.sample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Address Model structure")
public class Address {
	
	@ApiModelProperty("Address Line 1")
	private String addressLine1;
	@ApiModelProperty("Address Line 2")
	private String addressLine2;
	@ApiModelProperty("Residing State")
	private String state;
	@ApiModelProperty("Residing City")
	private String city;
	@ApiModelProperty("Residing Country")
	private String country;
	@ApiModelProperty("Pincode of the area")
	private long pincode;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

}
