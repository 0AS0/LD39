package com.its0as0.ld39;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

	private boolean[] keys = new boolean[65536];
	public boolean up, down, left, right, arrow_up, arrow_down, enter, back;

	public void update() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		arrow_up = keys[KeyEvent.VK_UP];
		arrow_down = keys[KeyEvent.VK_DOWN];
		enter = keys[KeyEvent.VK_ENTER];
		back = keys[KeyEvent.VK_BACK_SPACE];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
	}

	public void releaseAll() {
		up = down = left = right = arrow_up = arrow_down = enter = false;
	}

}
