package com.api.service;

import com.api.model.request.CreateUserRequest;
import com.api.model.request.UpdateUserRequest;

import io.restassured.response.Response;

public class UserService extends BaseService {

	private static final String BASE_URL = "/user";

	public Response createUser(CreateUserRequest payload) {

		return postRequest(payload, BASE_URL);
	}

	public Response getUser(String userName) {

		return getRequest(BASE_URL + "/" + userName);
	}

	public Response updateUser(UpdateUserRequest payload, String userName) {

		return updateRequest(payload, BASE_URL + "/" + userName);
	}
	
	public Response userLogin(String userName, String password) {

		return getUserLoggedin(userName, password, BASE_URL +  "/login");
	}

}
