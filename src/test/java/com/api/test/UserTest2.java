package com.api.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserTest2 {

	@Test(description = "Register new user")
	public void registerNewUserTest() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		String payload = "{\r\n" + "  \"id\": 1001,\r\n" + "  \"username\": \"User001\",\r\n"
				+ "  \"firstName\": \"Sumit\",\r\n" + "  \"lastName\": \"Sinha\",\r\n"
				+ "  \"email\": \"user001@email.com\",\r\n" + "  \"password\": \"passowrd123\",\r\n"
				+ "  \"phone\": \"1122334455\",\r\n" + "  \"userStatus\": 1001\r\n" + "}";

		RequestSpecification x = RestAssured.given();
		RequestSpecification y = x.header("Content-Type", "application/json");
		RequestSpecification z = y.body(payload);
		Response response = z.post("/user");

		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);

	}
}
