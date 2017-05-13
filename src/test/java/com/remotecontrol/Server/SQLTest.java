package com.remotecontrol.Server;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.server.dao.UserDao;
import com.server.model.UserModel;
import com.server.utils.SQLManager;

public class SQLTest {

	@Test
	public void test() {
		SqlSessionFactory factory = SQLManager.getSessionFactory();
		SqlSession session = factory.openSession();
		try{
			UserDao userDao = session.getMapper(UserDao.class);
			UserModel user = userDao.findUserByName("dada");
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}
