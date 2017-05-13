package com.server.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessModule {
	private static BusinessModule netModule = null;
	private static final Logger logger = LoggerFactory.getLogger(BusinessModule.class);
	
	private static final int port = 5432;
	
	private BusinessModule(){};
	
	public static BusinessModule getInstance(){
		if(netModule == null){
			netModule = new BusinessModule();
			netModule.init();
		}
		return netModule;
	}
	
	public void init(){
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		TextLineCodecFactory textLineCoder = new TextLineCodecFactory(
				Charset.forName("UTF-8"));
		textLineCoder.setDecoderMaxLineLength(1024 * 1024);
		textLineCoder.setEncoderMaxLineLength(1024 * 1024);
		acceptor.getFilterChain().addLast(
				"codec",
				new ProtocolCodecFilter(textLineCoder));
//		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
		acceptor.setHandler(BusinessHandler.getInstance());
		SocketSessionConfig dcfg = acceptor.getSessionConfig();  
        dcfg.setReadBufferSize(4096);// 设置接收最大字节默认2048  
        dcfg.setMaxReadBufferSize(65536);  
        dcfg.setReceiveBufferSize(1024);// 设置输入缓冲区的大小  
        dcfg.setSendBufferSize(1024);// 设置输出缓冲区的大小  
        
		InetSocketAddress address = new InetSocketAddress(port);
		try {
			acceptor.bind(address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("业务处理服务器开启成功");
	}
}
