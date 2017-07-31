package com.its0as0.ld39.menu;

import java.awt.Graphics;

import com.its0as0.ld39.Input;

public abstract class Menu {

	protected Input input;
	protected int selected = 0;

	public Menu(Input input) {
		this.input = input;
	}

	public abstract void update();

	public abstract void render(Graphics g);

}
