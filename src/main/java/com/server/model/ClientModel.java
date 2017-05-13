package com.server.model;

public class ClientModel {
	private String username;
	private ControllerModel controller;
	private ControlledModel controlled;
	public ControllerModel getController() {
		return controller;
	}
	public void setController(ControllerModel controller) {
		this.controller = controller;
	}
	public ControlledModel getControlled() {
		return controlled;
	}
	public void setControlled(ControlledModel controlled) {
		this.controlled = controlled;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
