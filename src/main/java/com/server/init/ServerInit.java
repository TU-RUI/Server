package com.server.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.server.net.BusinessModule;
import com.server.net.ScreenModule;


public class ServerInit {

	private static final Logger logger = LoggerFactory.getLogger(ServerInit.class);
	
	public static void main(String[] args) {
		logger.info("业务处理服务器正在启动...");
		BusinessModule.getInstance();
		logger.info("画面传输服务器正在启动...");
		ScreenModule.getInstance();
	}
}
