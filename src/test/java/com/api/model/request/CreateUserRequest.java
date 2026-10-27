package com.api.model.request;

public class CreateUserRequest {

	private String id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String userStatus;

	public CreateUserRequest(String id, String username, String firstName, String lastName, String email,
			String password, String phone, String userStatus) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.userStatus = userStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "CreateUserRequest [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + ", phone=" + phone + ", userStatus="
				+ userStatus + "]";
	}

	public static class Builder {
		private String id;
		private String username;
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		private String phone;
		private String userStatus;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
 
		public Builder userStatus(String userStatus) {
			this.userStatus = userStatus;
			return this;
		}

		public CreateUserRequest Build() {
			CreateUserRequest createUserRequest = new CreateUserRequest(id, username, firstName, lastName, email,
					password, phone, userStatus);
			return createUserRequest;
		}
	}
}
