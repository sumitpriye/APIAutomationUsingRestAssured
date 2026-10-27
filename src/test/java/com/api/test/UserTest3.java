package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; //static import is used to improve readbility
import io.restassured.response.Response;

public class UserTest3 {

	@Test(description = "Register new user")
	public void registerNewUserTest() {

		String payload = "{\r\n" + "  \"id\": 1001,\r\n" + "  \"username\": \"User001\",\r\n"
				+ "  \"firstName\": \"Sumit\",\r\n" + "  \"lastName\": \"Sinha\",\r\n"
				+ "  \"email\": \"user001@email.com\",\r\n" + "  \"password\": \"passowrd123\",\r\n"
				+ "  \"phone\": \"1122334455\",\r\n" + "  \"userStatus\": 1001\r\n" + "}";

		Response response = given().baseUri("https://petstore.swagger.io/v2").header("Content-Type", "application/json")
				.body(payload).post("/user");

		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);

	}
}
