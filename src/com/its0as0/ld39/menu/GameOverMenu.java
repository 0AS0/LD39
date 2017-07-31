package com.its0as0.ld39.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.its0as0.ld39.Game;
import com.its0as0.ld39.Input;

public class GameOverMenu extends Menu {

	private String option = "Backspace";

	public GameOverMenu(Input input) {
		super(input);
	}

	public void update() {
		option = "> Backspace";
		if (input.back) Game.menu = new MainMenu(input);
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Verdana", 0, 75));
		g.drawString("Game Over", 428, 203);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 75));
		g.drawString("Game Over", 425, 200);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 35));
		String[] text = {
			" You did not get to the source in time,", //
			"    resulting in the city losing power.", //
			"", //
		};
		for (int i = 0; i < text.length; i++) {
			g.setColor(Color.BLACK);
			g.drawString(text[i], 290, 273 + i * 42);
			g.setColor(Color.WHITE);
			g.drawString(text[i], 287, 270 + i * 42);
		}

		g.setColor(Color.BLACK);
		g.drawString(option, 1037, 698);
		g.setColor(Color.WHITE);
		g.drawString(option, 1035, 695);
	}

}
