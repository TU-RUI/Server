package com.server.manager;

import org.apache.mina.core.session.IoSession;

import com.server.model.ClientModel;
import com.server.net.ClientManager;
import com.server.net.ClientType;

public class CMDManager {
	private static CMDManager cmdManager;

	public static CMDManager getInstance() {
		if (cmdManager == null) {
			cmdManager = new CMDManager();
			cmdManager.init();
		}
		return cmdManager;
	}

	private void init() {

	}

	public void handle(IoSession session, Object message, String tempid,
			String client) {
		ClientModel clientModel = ClientManager.getInstance()
				.findClientModelByMD5(tempid);
		if (ClientType.CONTROLLER.equals(client)) {
			if (clientModel != null 
					&& clientModel.getControlled() != null
					&& clientModel.getControlled().getSession().isConnected()) {
				clientModel.getControlled().getSession().write(message);
			}
		} else if (ClientType.CONTROLLED.equals(client)) {
			if (clientModel != null 
					&& clientModel.getController() != null
					&& clientModel.getController().getSession().isConnected()) {
				clientModel.getController().getSession().write(message);
			}
		}

	}
}
