package com.server.utils;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class CoverFXtoAWT {
	
	public static int getAWTKeyCode(KeyCode keyCode){
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.B) return KeyEvent.VK_B;
		if(keyCode == KeyCode.C) return KeyEvent.VK_C;
		if(keyCode == KeyCode.D) return KeyEvent.VK_D;
		if(keyCode == KeyCode.E) return KeyEvent.VK_E;
		if(keyCode == KeyCode.F) return KeyEvent.VK_F;
		if(keyCode == KeyCode.G) return KeyEvent.VK_G;
		if(keyCode == KeyCode.H) return KeyEvent.VK_H;
		if(keyCode == KeyCode.I) return KeyEvent.VK_I;
		if(keyCode == KeyCode.J) return KeyEvent.VK_J;
		if(keyCode == KeyCode.K) return KeyEvent.VK_K;
		if(keyCode == KeyCode.L) return KeyEvent.VK_L;
		if(keyCode == KeyCode.M) return KeyEvent.VK_M;
		if(keyCode == KeyCode.N) return KeyEvent.VK_N;
		if(keyCode == KeyCode.O) return KeyEvent.VK_O;
		if(keyCode == KeyCode.P) return KeyEvent.VK_P;
		if(keyCode == KeyCode.Q) return KeyEvent.VK_Q;
		if(keyCode == KeyCode.R) return KeyEvent.VK_R;
		if(keyCode == KeyCode.S) return KeyEvent.VK_S;
		if(keyCode == KeyCode.T) return KeyEvent.VK_T;
		if(keyCode == KeyCode.U) return KeyEvent.VK_U;
		if(keyCode == KeyCode.V) return KeyEvent.VK_V;
		if(keyCode == KeyCode.W) return KeyEvent.VK_W;
		if(keyCode == KeyCode.X) return KeyEvent.VK_X;
		if(keyCode == KeyCode.Y) return KeyEvent.VK_Y;
		if(keyCode == KeyCode.Z) return KeyEvent.VK_Z;
		if(keyCode == KeyCode.NUMPAD0) return KeyEvent.VK_NUMPAD0;
		if(keyCode == KeyCode.NUMPAD1) return KeyEvent.VK_NUMPAD1;
		if(keyCode == KeyCode.NUMPAD2) return KeyEvent.VK_NUMPAD2;
		if(keyCode == KeyCode.NUMPAD3) return KeyEvent.VK_NUMPAD3;
		if(keyCode == KeyCode.NUMPAD4) return KeyEvent.VK_NUMPAD4;
		if(keyCode == KeyCode.NUMPAD5) return KeyEvent.VK_NUMPAD5;
		if(keyCode == KeyCode.NUMPAD6) return KeyEvent.VK_NUMPAD6;
		if(keyCode == KeyCode.NUMPAD7) return KeyEvent.VK_NUMPAD7;
		if(keyCode == KeyCode.NUMPAD8) return KeyEvent.VK_NUMPAD8;
		if(keyCode == KeyCode.NUMPAD9) return KeyEvent.VK_NUMPAD9;
		if(keyCode == KeyCode.DIGIT0) return KeyEvent.VK_0;
		if(keyCode == KeyCode.DIGIT1) return KeyEvent.VK_1;
		if(keyCode == KeyCode.DIGIT2) return KeyEvent.VK_2;
		if(keyCode == KeyCode.DIGIT3) return KeyEvent.VK_3;
		if(keyCode == KeyCode.DIGIT4) return KeyEvent.VK_4;
		if(keyCode == KeyCode.DIGIT5) return KeyEvent.VK_5;
		if(keyCode == KeyCode.DIGIT6) return KeyEvent.VK_6;
		if(keyCode == KeyCode.DIGIT7) return KeyEvent.VK_7;
		if(keyCode == KeyCode.DIGIT8) return KeyEvent.VK_8;
		if(keyCode == KeyCode.DIGIT9) return KeyEvent.VK_9;
		
		if(keyCode == KeyCode.CONTROL) return KeyEvent.VK_CONTROL;
		if(keyCode == KeyCode.SHIFT) return KeyEvent.VK_SHIFT;
		if(keyCode == KeyCode.ALT) return KeyEvent.VK_ALT;
		if(keyCode == KeyCode.SPACE) return KeyEvent.VK_SPACE;
		if(keyCode == KeyCode.PAGE_UP) return KeyEvent.VK_PAGE_UP;
		if(keyCode == KeyCode.PAGE_DOWN) return KeyEvent.VK_PAGE_DOWN;
		if(keyCode == KeyCode.END) return KeyEvent.VK_END;
		if(keyCode == KeyCode.TAB) return KeyEvent.VK_TAB;
		if(keyCode == KeyCode.BACK_SPACE) return KeyEvent.VK_BACK_SPACE;
		if(keyCode == KeyCode.CAPS) return KeyEvent.VK_CAPS_LOCK;
		if(keyCode == KeyCode.HOME) return KeyEvent.VK_HOME;
		if(keyCode == KeyCode.NUM_LOCK) return KeyEvent.VK_NUM_LOCK;
		if(keyCode == KeyCode.ESCAPE) return KeyEvent.VK_ESCAPE;
		if(keyCode == KeyCode.DELETE) return KeyEvent.VK_DELETE;
		if(keyCode == KeyCode.ADD) return KeyEvent.VK_ADD;
		if(keyCode == KeyCode.NUM_LOCK) return KeyEvent.VK_NUM_LOCK;
		if(keyCode == KeyCode.NUM_LOCK) return KeyEvent.VK_NUM_LOCK;
		
		if(keyCode == KeyCode.UP) return KeyEvent.VK_UP;
		if(keyCode == KeyCode.DOWN) return KeyEvent.VK_DOWN;
		if(keyCode == KeyCode.LEFT) return KeyEvent.VK_LEFT;
		if(keyCode == KeyCode.RIGHT) return KeyEvent.VK_RIGHT;
		
		if(keyCode == KeyCode.F1) return KeyEvent.VK_F1;
		if(keyCode == KeyCode.F2) return KeyEvent.VK_F2;
		if(keyCode == KeyCode.F3) return KeyEvent.VK_F3;
		if(keyCode == KeyCode.F4) return KeyEvent.VK_F4;
		if(keyCode == KeyCode.F5) return KeyEvent.VK_F5;
		if(keyCode == KeyCode.F6) return KeyEvent.VK_F6;
		if(keyCode == KeyCode.F7) return KeyEvent.VK_F7;
		if(keyCode == KeyCode.F8) return KeyEvent.VK_F8;
		if(keyCode == KeyCode.F9) return KeyEvent.VK_F9;
		if(keyCode == KeyCode.F10) return KeyEvent.VK_F10;
		if(keyCode == KeyCode.F11) return KeyEvent.VK_F11;
		if(keyCode == KeyCode.F12) return KeyEvent.VK_F12;


		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		if(keyCode == KeyCode.A) return KeyEvent.VK_A;
		return -1;
	}
	
	public static int getMouseCode(MouseButton mouseButton){
		if(mouseButton.equals(MouseButton.PRIMARY)) return InputEvent.BUTTON1_MASK;	
		if(mouseButton.equals(MouseButton.SECONDARY)) return InputEvent.BUTTON3_MASK;	
		if(mouseButton.equals(MouseButton.MIDDLE)) return InputEvent.BUTTON2_MASK;	
		return 0;
	}
	
}
