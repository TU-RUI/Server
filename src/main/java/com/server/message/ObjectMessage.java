package com.server.message;

import java.io.Serializable;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class ObjectMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2097501789093198041L;

	//消息类型
	private String msgType;
	
	//按键号
	private KeyCode key;
	
	//鼠标移动
	private double x;
	private double y;
	
	//鼠标点击
	private MouseButton mouseButton;
	
//	画面数据
	private byte[] image;
	
	//身份标示
	private String tempid;
	
	//额外信息
	private String Message;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public KeyCode getKey() {
		return key;
	}

	public void setKey(KeyCode key) {
		this.key = key;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public MouseButton getMouseButton() {
		return mouseButton;
	}

	public void setMouseButton(MouseButton mouseButton) {
		this.mouseButton = mouseButton;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getTempid() {
		return tempid;
	}

	public void setTempid(String tempid) {
		this.tempid = tempid;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String Message) {
		this.Message = Message;
	}
	
	
}
