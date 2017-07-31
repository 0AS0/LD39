package com.its0as0.ld39.util;

public class Timer {

	public int seconds;
	private boolean up;

	public Timer() {
		seconds = 0;
		up = true;
	}

	public Timer(int seconds) {
		this.seconds = seconds;
		up = false;
	}

	public void update() {
		if (up) seconds++;
		else {
			if (seconds <= 0) return;
			seconds--;
		}
	}
	
}
