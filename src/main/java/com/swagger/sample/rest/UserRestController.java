package com.swagger.sample.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.sample.model.Address;
import com.swagger.sample.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("This is a sample API")
@RestController
@RequestMapping("/api/v1/")
public class UserRestController {
	private static List<User> usersList = new ArrayList<User>();
	private static int idCnt = 1;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	@ApiOperation("For testing the state of API")
	public String ping() {
		return "API is running successfully";
	}

	@ApiOperation("Saves a new user")
	@ApiResponses({ @ApiResponse(code = 201, message = "User created successfully") })
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Void> addUser(@ApiParam("User object") @RequestBody User user) {
		user.setNo(idCnt);
		idCnt++;
		usersList.add(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation("Gets the particular user")
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> fetchUserById(
			@PathVariable("userId") @ApiParam("Id of the user to be fetched") Integer userId) {
		for (User u : usersList) {
			if (u.getNo() == userId) {
				return new ResponseEntity<User>(u, HttpStatus.OK);
			}
		}

		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

	}

	@ApiOperation("Updates a particular user")
	@ApiResponses({ @ApiResponse(code = 200, message = "User updated successfully"),
			@ApiResponse(code = 404, message = "User record doesnot exists") })
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(
			@PathVariable("userId") @ApiParam("Id of the user to be updated") Integer userId,
			@ApiParam("User object") @RequestBody User updateUser) {
		for (User u : usersList) {
			if (u.getNo() == userId) {
				usersList.remove(u);
				updateUser.setNo(userId);
				usersList.add(updateUser);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

	@ApiOperation("Deletes a particular user")
	@ApiResponses({ @ApiResponse(code = 200, message = "User deleted successfully"),
			@ApiResponse(code = 404, message = "User record doesnot exists") })
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(
			@PathVariable("userId") @ApiParam("Id of the user to be deleted") Integer userId) {
		for (User u : usersList) {
			if (u.getNo() == userId) {
				usersList.remove(u);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

	@ApiOperation("Gets all the users")
	@ApiResponse(code = 200, message = "OKK")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> fetchUsers() {
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
	}

	static {
		User u;
		Address addr;
		Random r = new Random();
		for (; idCnt <= 5; idCnt++) {
			u = new User();
			u.setNo(idCnt);
			u.setFirstName("f" + idCnt);
			u.setComments("User no" + idCnt);

			addr = new Address();
			addr.setAddressLine1("addressLine1" + idCnt);
			addr.setAddressLine2("addressLine2" + idCnt);
			addr.setCity("Hyd");
			addr.setPincode(r.nextLong());
			u.setAddress(addr);
			usersList.add(u);
		}
	}
}
