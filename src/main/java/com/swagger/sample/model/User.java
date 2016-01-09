package com.swagger.sample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("User Model Structure")
public class User {

	@ApiModelProperty("User Id/No")
	private int no;
	@ApiModelProperty("First Name of the user")
	private String firstName;
	@ApiModelProperty("Last Name of the user")
	private String lastName;
	@ApiModelProperty("Address of the user")
	private Address address;
	@ApiModelProperty("Comments")
	private String comments;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
