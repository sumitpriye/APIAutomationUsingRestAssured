package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.model.request.CreateUserRequest;
import com.api.model.request.UpdateUserRequest;
import com.api.model.response.CreateUserResponse;
import com.api.model.response.GetUserResponse;
import com.api.model.response.UpdateUserResponse;
import com.api.service.UserService;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class UserTest {

	@Test(description = "Register new user", priority = 1)
	public void registerNewUserTest() {

//		CreateUserRequest payload = new CreateUserRequest("1001", "User001", "Sumit", "Sinha", "user001@email.com",
//				"passowrd123", "1122334455", "1001");

		CreateUserRequest payload = new CreateUserRequest.Builder().email("user001@email.com").firstName("Sumit").id("1001").lastName("Sinha")
				.password("passowrd123").phone("1122334455").username("User001").userStatus("1001").Build();

		UserService userService = new UserService();
		Response response = userService.createUser(payload);

		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);

		CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
		System.out.println(createUserResponse.getCode());
		System.out.println(createUserResponse.getMessage());
		System.out.println(createUserResponse.getType());

		Assert.assertEquals(createUserResponse.getCode(), 200);
		Assert.assertEquals(createUserResponse.getMessage(), "1001");
		Assert.assertEquals(createUserResponse.getType(), "unknown");

	}

	@Test(description = "Get the user by userId", priority = 2)
	public void getUserTest() {
		UserService userService = new UserService();
		Response response = userService.getUser("User001");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);

		GetUserResponse getUserResponse = response.as(GetUserResponse.class);
		Assert.assertEquals(getUserResponse.getFirstName(), "Sumit");

	}

	@Test(description = "Update the user using PUT request", priority = 3)
	public void updateUser() {

		UpdateUserRequest updateUserRequest = new UpdateUserRequest("1001", "User001", "Sumit", "Stephen",
				"user001@email.com", "passowrd123", "1122334455", "1001");

		UserService userService = new UserService();

		String userName = "User001";

		Response response = userService.updateUser(updateUserRequest, userName);
		System.out.println(response.asPrettyString());
		UpdateUserResponse updateUserResponse = response.as(UpdateUserResponse.class);

		Assert.assertEquals(updateUserResponse.getCode(), 200);
		Assert.assertEquals(updateUserResponse.getMessage(), "1001");
		Assert.assertEquals(updateUserResponse.getType(), "unknown");

	}

	@Test(description = "Get user Logged in", priority = 4)
	public void userLoginTest() {

		UserService userService = new UserService();

		String userName = "User001";
		String password = "Password123";

		Response response = userService.userLogin(userName, password);
		System.out.println(response.asPrettyString());
//		UpdateUserResponse updateUserResponse = response.as(UpdateUserResponse.class);

//		Assert.assertEquals(updateUserResponse.getCode(), 200);
//		Assert.assertEquals(updateUserResponse.getMessage(), "1001");
//		Assert.assertEquals(updateUserResponse.getType(), "unknown");

	}

}
