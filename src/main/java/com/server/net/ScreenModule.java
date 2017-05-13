package com.server.net;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenModule {
	private static ScreenModule screenModule = null;
	private static final Logger logger = LoggerFactory.getLogger(ScreenModule.class);
	
	private static final int port = 5433;
	
	private ScreenModule(){};
	
	public static ScreenModule getInstance(){
		if(screenModule == null){
			screenModule = new ScreenModule();
			screenModule.init();
		}
		return screenModule;
		
	}
	
	public void init(){
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
//		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
//		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ImageProtoFactory()));
		ObjectSerializationCodecFactory codecFactory = new ObjectSerializationCodecFactory();
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(codecFactory) );
		acceptor.setHandler(ScreenHandler.getInstance());
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
		InetSocketAddress address = new InetSocketAddress(port);
		try {
			acceptor.bind(address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("画面传输服务器开启成功");
	}
}
