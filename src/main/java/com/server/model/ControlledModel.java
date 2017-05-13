package com.server.model;

import org.apache.mina.core.session.IoSession;

public class ControlledModel {
	private IoSession session;
	private IoSession TCPsession;
	private int width;
	private int height;
	private String os;
	
	public IoSession getSession() {
		return session;
	}
	public void setSession(IoSession session) {
		this.session = session;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public IoSession getTCPsession() {
		return TCPsession;
	}
	public void setTCPsession(IoSession tCPsession) {
		TCPsession = tCPsession;
	}
	
}
