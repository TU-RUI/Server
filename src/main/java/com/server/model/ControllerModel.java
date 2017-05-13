package com.server.model;

import org.apache.mina.core.session.IoSession;

public class ControllerModel {
	private IoSession session;
	private IoSession TCPsession;

	public IoSession getSession() {
		return session;
	}

	public void setSession(IoSession session) {
		this.session = session;
	}

	public IoSession getTCPsession() {
		return TCPsession;
	}

	public void setTCPsession(IoSession tCPsession) {
		TCPsession = tCPsession;
	}
}
