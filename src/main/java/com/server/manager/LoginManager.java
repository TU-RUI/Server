package com.server.manager;

import org.apache.ibatis.session.SqlSession;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.server.dao.UserDao;
import com.server.model.ClientModel;
import com.server.model.ControlledModel;
import com.server.model.ControllerModel;
import com.server.model.UserModel;
import com.server.net.ClientManager;
import com.server.net.ClientType;
import com.server.net.MsgType;
import com.server.utils.MD5Util;
import com.server.utils.SQLManager;

public class LoginManager {
	private static LoginManager loginManager;
	private static final Logger logger = LoggerFactory.getLogger(LoginManager.class);
	
	public static LoginManager getInstance(){
		if(loginManager == null){
			loginManager = new LoginManager();
			loginManager.init();
		}
		return loginManager;
	}
	
	private void init(){
		
	}
	
	public void handle(IoSession session , Object message,String username){
		JSONObject json = JSON.parseObject((String) message);

		String password = json.getString("password");
		String ctrlType = json.getString("controlType");
		SqlSession sqlSession = SQLManager.getSessionFactory()
				.openSession();
		try {
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			UserModel user = userDao.findUserByName(username);

			JSONObject rejson = new JSONObject();
			rejson.put("msgType", MsgType.LOGIN_RESULT);
			// 没有该用户
			if (user == null) {
				rejson.put(MsgType.LOGIN_RESULT, MsgType.NOSUCHUSER);
			}else if (password.equals(user.getPassword())) {
				// 密码正确
				rejson.put(MsgType.LOGIN_RESULT, MsgType.LOGIN_SUCCESS);
				rejson.put("password", password);
				String md5 = MD5Util.md5Encode(username+password);
				rejson.put("tempid", md5);
				//被控端登陆
				if (ctrlType.equals(ClientType.CONTROLLED)) {
					ControlledModel model = new ControlledModel();
					model.setSession(session);
					int width = json.getIntValue("width");
					int height = json.getIntValue("height");
					String os = json.getString("os");
					model.setHeight(height);
					model.setWidth(width);
					model.setOs(os);
					ClientManager.getInstance().addControlled(md5, model);
					
				//控制端登陆
				} else if (ctrlType.equals(ClientType.CONTROLLER)) {
					ControllerModel model = new ControllerModel();
					model.setSession(session);
					ClientManager.getInstance().addController(md5, model);
					ClientModel clientModel = ClientManager
							.getInstance().findClientModelByMD5(md5);
					if (clientModel.getControlled() != null) {
						JSONObject json1 = new JSONObject();
						
						json1.put("os", clientModel.getControlled().getOs());
						json1.put("width", clientModel.getControlled().getWidth());
						json1.put("height", clientModel.getControlled().getHeight());
						json1.put("devip", clientModel.getControlled().getSession().getRemoteAddress().toString());
						rejson.put("controlled", json1);
					}
				}
			} else {
				// 密码错误
				rejson.put(MsgType.LOGIN_RESULT, MsgType.WRONGPASSWORD);
			}
			session.write(rejson.toJSONString());
			logger.info("回复消息:{}",rejson.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
