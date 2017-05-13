package com.server.net;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.server.message.ObjectMessage;
import com.server.model.ClientModel;

public class ScreenHandler extends IoHandlerAdapter {
	private static final Logger logger = LoggerFactory
			.getLogger(ScreenHandler.class);

	private static ScreenHandler netHandler = null;

	public static ScreenHandler getInstance() {
		if (netHandler == null) {
			netHandler = new ScreenHandler();
		}
		return netHandler;
	}

	private ScreenHandler() {

	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
		logger.info(session.getRemoteAddress().toString() + "断开画面传输服务");
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		super.messageReceived(session, message);
		ObjectMessage objectMessage = (ObjectMessage) message;
		String tempId = objectMessage.getTempid();
		String msgType = objectMessage.getMsgType();
		if (tempId == null) {
			return;
		}
		if (MsgType.AUTH.equals(msgType)) {
			ClientModel clientModel = ClientManager.getInstance()
					.findClientModelByMD5(tempId);
			if (ClientType.CONTROLLED.equals(objectMessage.getMessage())) {
				if (clientModel.getControlled() != null) {
					clientModel.getControlled().setTCPsession(session);
				}
			} else if (ClientType.CONTROLLER.equals(objectMessage.getMessage())) {
				if (clientModel.getController() != null) {
					clientModel.getController().setTCPsession(session);
				}
			}

		} else if (MsgType.SCREEN.equals(msgType)) {
			ClientModel clientModel = ClientManager.getInstance()
					.findClientModelByMD5(tempId);
			if (clientModel != null
					&& clientModel.getController() != null
					&& clientModel.getController().getTCPsession() != null
					&& clientModel.getController().getTCPsession()
							.isConnected()) {
				clientModel.getController().getTCPsession().write(message);
			} else {
				ObjectMessage returnMessage = new ObjectMessage();
				returnMessage.setMsgType(MsgType.STOP_MONITOR);
				returnMessage.setMessage("控制端连接断开");
				session.write(returnMessage);
			}
		} else if (MsgType.KEY_PRESS.equals(msgType)
				|| MsgType.KEY_RELEASE.equals(msgType)
				|| MsgType.MOUSE_MOVE.equals(msgType)
				|| MsgType.MOUSE_PRESS.equals(msgType)
				|| MsgType.MOUSE_RELEASE.equals(msgType)) {
			ClientModel clientModel = ClientManager.getInstance()
					.findClientModelByMD5(tempId);
			if (clientModel != null
					&& clientModel.getControlled() != null
					&& clientModel.getControlled().getTCPsession() != null
					&& clientModel.getControlled().getTCPsession()
							.isConnected()) {
				clientModel.getControlled().getTCPsession().write(message);
			} else {
				ObjectMessage returnMessage = new ObjectMessage();
				returnMessage.setMsgType(MsgType.STOP_MONITOR);
				returnMessage.setMessage("受控端连接断开");
				session.write(returnMessage);
			}
		} else if (MsgType.MONITOR.equals(msgType)) {
			ClientModel clientModel = ClientManager.getInstance()
					.findClientModelByMD5(tempId);
			if (clientModel != null
					&& clientModel.getControlled() != null
					&& clientModel.getControlled().getTCPsession() != null
					&& clientModel.getControlled().getTCPsession()
							.isConnected()) {
				clientModel.getControlled().getTCPsession().write(message);
			}

		}

	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		logger.info(session.getRemoteAddress() +"断开视频连接");
	}

}
