package com.server.model;

public class UserModel {
	private int id;
	private String username;
	private String password;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("[id=");
		sb.append(id);
		sb.append(",username=");
		sb.append(username);
		sb.append(",password=");
		sb.append(password);
		sb.append(",email=");
		sb.append(email);
		sb.append("]");
		return sb.toString();
	}
}
