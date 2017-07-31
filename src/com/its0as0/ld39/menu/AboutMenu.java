package com.its0as0.ld39.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.its0as0.ld39.Game;
import com.its0as0.ld39.Input;

public class AboutMenu extends Menu {

	private String option = "Backspace";

	public AboutMenu(Input input) {
		super(input);
	}

	public void update() {
		option = "> " + "Backspace";
		if (input.back) {
			Game.menu = new MainMenu(input);
		}

		if (input.back) {
			Game.menu = new MainMenu(input);
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 35));
		String[] text = {
			" Running out of Power is a game created by Andrew Shepherd.", //
			" Ludum Dare is a 48 hour game development competition. This game ", //
			" was made in under 10 hours. Everything was made by me within ", //
			" that time.", //
			"", //
			" Created for the 39th Ludum Dare compo.", //
			" You are an electrical current, you have to make your way to the ", //
			" destination in under 30 seconds.", //
			"", //
			" Any questions? Tweet me at @Its0AS0", //
			"", //
			" Thanks for playing! :)"
		};
		for (int i = 0; i < text.length; i++) {
			g.setColor(Color.BLACK);
			g.drawString(text[i], 3, 53 + i * 40);
			g.setColor(Color.WHITE);
			g.drawString(text[i], 1, 50 + i * 40);
		}

		g.setColor(Color.BLACK);
		g.drawString(option, 1037, 698);
		g.setColor(Color.WHITE);
		g.drawString(option, 1035, 695);
	}
}
