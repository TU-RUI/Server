package com.server.net;

public class MsgType {
	// 登陆
	public static final String LOGIN = "login";
	// 登陆结果
	public static final String LOGIN_RESULT = "loginresult";
	// 登陆成功
	public static final String LOGIN_SUCCESS = "loginsuccess";
	// 没有该用户
	public static final String NOSUCHUSER = "nosuchuser";
	// 密码错误
	public static final String WRONGPASSWORD = "wrongpassword";

	// 注册
	public static final String REGIST = "regist";
	// 注册结果
	public static final String REGIST_RESULT = "registresult";
	// 注册成功
	public static final String REGIST_SUCCESS = "registsuccess";
	// 邮箱已被注册
	public static final String EMAIL_REGISTERED = "emailregistered";
	// 用户名重复
	public static final String DUPLICATENAME = "duplicatename";

	// 重置密码
	public static final String RESETPWD = "restpwd";
	// 重置密码结果
	public static final String RESTPWD_RESULT = "restpwdresult";
	// 修改密码
	public static final String CHANGEPWD = "changepwd";
	// 修改密码结果
	public static final String CHANGEPWD_RESULT = "changepwdresult";
	// 开始监视
	public static final String MONITOR = "monitor";
	//停止监视
	public static final String STOP_MONITOR = "stopmonitor";
	
	//发送cmd命令
	public static final String CMD = "cmd";
	
	//认证身份
	public static final String AUTH = "auth";
	
	//鼠标移动事件
	public static final String MOUSE_MOVE = "mousemove";
	
	//鼠标点击事件
	public static final String MOUSE_PRESS = "mousepress";
	//鼠标释放事件
	public static final String MOUSE_RELEASE = "mouserelease";
	
	//键盘事件
	public static final String KEY_PRESS = "key_press";
	public static final String KEY_RELEASE = "key_release";
	
	//图片数据
	public static final String SCREEN = "screen";
	
	//滚轮
	public static final String SCROLLUP = "scrollup";
	public static final String SCROLLDOWN = "scrolldown";
	
	
	//通知信息
	public static final String NOTIFICATION = "notification";
	
	//未知异常
	public static final String EXCEPTION = "exception";

	
	
}
