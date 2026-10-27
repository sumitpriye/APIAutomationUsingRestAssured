package com.api.service;

import static io.restassured.RestAssured.given;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
//	This class will be responsinble for 
//	handling base uri
//	creating request
//	handling response
//	its a wrapper for resta ssured Abstraction over rest assured

	private static final String BASE_URL = "https://petstore.swagger.io/v2";
	RequestSpecification requestSpecification;

	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}

	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response getRequest(String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).get(endpoint);
	}

	protected Response updateRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}

	protected Response getUserLoggedin(String UserName, String password, String endpoint) {
		return requestSpecification.queryParam("username", UserName).queryParam("password", password).get(endpoint);
	}
}
