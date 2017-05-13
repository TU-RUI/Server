package com.server.manager;

import org.apache.ibatis.session.SqlSession;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.server.dao.UserDao;
import com.server.model.UserModel;
import com.server.net.MsgType;
import com.server.utils.SQLManager;

public class RegistManager {
	private static RegistManager registManager;
	private static final Logger logger = LoggerFactory.getLogger(RegistManager.class);

	public static RegistManager getInstance() {
		if (registManager == null) {
			registManager = new RegistManager();
			registManager.init();
		}
		return registManager;
	}

	private void init() {
	}

	public void handle(IoSession session, Object message, String username) throws Exception{
		JSONObject json = JSON.parseObject((String) message);

		String password = json.getString("password");
		String email = json.getString("email");
		SqlSession sqlSession = SQLManager.getSessionFactory().openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		UserModel user = new UserModel();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		JSONObject rejson = new JSONObject();

		rejson.put("msgType", MsgType.REGIST_RESULT);
		// TODO 用户名占用和邮箱占用的情况!
		try {
			userDao.insertUser(user);
			sqlSession.commit();
			rejson.put(MsgType.REGIST_RESULT, MsgType.REGIST_SUCCESS);
		} catch (Exception e) {
			System.err.println(user + "插入失败");
			rejson.put(MsgType.REGIST_RESULT, MsgType.DUPLICATENAME);
		}
		logger.info("发送消息:{}",rejson.toJSONString());
		session.write(rejson.toJSONString());
	}
}
