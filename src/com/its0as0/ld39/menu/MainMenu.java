package com.its0as0.ld39.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.its0as0.ld39.Game;
import com.its0as0.ld39.Input;

public class MainMenu extends Menu {

	private String[] options = {
		"Play", "About", "Quit"
	};

	public MainMenu(Input input) {
		super(input);
	}

	private int timer = 18;

	public void update() {
		if (timer > 0) timer--;
		if (input.arrow_down && selected < options.length && timer == 0) {
			selected++;
			timer = 10;
		}

		if (input.arrow_up && selected > 0 && timer == 0) {
			selected--;
			timer = 10;
		}

		if (selected < 0) selected = 0;
		if (selected >= 2) selected = 2;

		if (selected == 0) {
			options[selected] = "> " + "Play";
			if (input.enter) Game.state = State.GAME;
		} else {
			options[0] = "Play";
		}

		if (selected == 1) {
			options[selected] = "> " + "About";
			if (input.enter) Game.menu = new AboutMenu(input);
		} else {
			options[1] = "About";
		}

		if (selected == 2) {
			options[selected] = "> " + "Quit";
			if (input.enter) System.exit(0);
		} else {
			options[2] = "Quit";
		}
	}

	public void render(Graphics g) {
		g.setFont(new Font("Verdana", 0, 75));
		g.setColor(Color.BLACK);
		g.drawString("Running out of Power", 268, 203);
		g.setFont(new Font("Verdana", 0, 20));
		g.drawString("A game by Andrew Shepherd", 502, 252);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 75));
		g.drawString("Running out of Power", 265, 200);
		g.setFont(new Font("Verdana", 0, 20));
		g.drawString("A game by Andrew Shepherd", 500, 250);

		g.setFont(new Font("Verdana", 0, 25));
		for (int i = 0; i < options.length; i++) {
			g.setColor(Color.BLACK);
			g.drawString(options[i], 602, 452 + i * 30);
			g.setColor(Color.WHITE);
			g.drawString(options[i], 600, 450 + i * 30);
		}
	}

}
