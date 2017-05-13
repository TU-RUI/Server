package com.server.net;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.server.manager.CMDManager;
import com.server.manager.LoginManager;
import com.server.manager.RegistManager;

public class BusinessHandler extends IoHandlerAdapter {
	private static final Logger logger = LoggerFactory
			.getLogger(BusinessHandler.class);

	private static BusinessHandler netHandler = null;

	private LoginManager loginManager;
	private RegistManager registManager;
	private CMDManager cmdManager;

	public static BusinessHandler getInstance() {
		if (netHandler == null) {
			netHandler = new BusinessHandler();
		}
		return netHandler;
	}

	private BusinessHandler() {
		loginManager = LoginManager.getInstance();
		registManager = RegistManager.getInstance();
		cmdManager = CMDManager.getInstance();
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		super.messageReceived(session, message);
		try {
			if (message instanceof String) {
				JSONObject json = JSON.parseObject((String) message);
				if (!json.containsKey("msgType")) {
					return;
				}
				String msgType = json.getString("msgType");
				String username = "";
				logger.info("收到消息,消息类型:{},消息:{}", msgType, message.toString());
				switch (msgType) {
				// 登录
				case MsgType.LOGIN:
					if (!json.containsKey("username")
							|| !json.containsKey("password")) {
						return;
					}
					username = json.getString("username");
					loginManager.handle(session, message, username);
					break;
				case MsgType.REGIST:
					if (!json.containsKey("username")
							|| !json.containsKey("password")) {
						return;
					}
					username = json.getString("username");
					registManager.handle(session, message, username);
					break;
				case MsgType.CMD:
					if (!json.containsKey("tempid")
							|| !json.containsKey("message")) {
						return;
					}
					String tempid = json.getString("tempid");
					String client = json.getString("client");
					cmdManager.handle(session, message, tempid, client);
					break;
				}
			}
		} catch (Exception e) {
			JSONObject json = new JSONObject();
			json.put("msgType", MsgType.EXCEPTION);
			session.write(json.toJSONString());
			e.printStackTrace();
		}
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
		logger.info(session.getRemoteAddress().toString() + "断开业务服务");
	}
	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		logger.info(session.getRemoteAddress() + "断开业务连接");
	}
}
