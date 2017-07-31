package com.its0as0.ld39;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.its0as0.ld39.entity.mob.Mob;
import com.its0as0.ld39.entity.mob.Player;
import com.its0as0.ld39.graphics.Image;
import com.its0as0.ld39.graphics.Render;
import com.its0as0.ld39.level.Coordinate;
import com.its0as0.ld39.level.Level;
import com.its0as0.ld39.menu.GameOverMenu;
import com.its0as0.ld39.menu.MainMenu;
import com.its0as0.ld39.menu.Menu;
import com.its0as0.ld39.menu.State;
import com.its0as0.ld39.util.Timer;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private int width = 1280 / 3;
	private int height = 720 / 3;
	private int scale = 3;

	private boolean running = false;
	private JFrame frame;
	private Thread thread;
	private Input input;
	private Level level;
	private Player player;
	public static Timer countdown;

	public static Menu menu;
	public static State state;

	private Image bg_img = new Image();

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private BufferedImage bg_image;

	private Render render;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		frame = new JFrame("Voltage Velocity");
		render = new Render(width, height);
		input = new Input();
		level = Level.level;
		Coordinate spawn = new Coordinate(3, 9);
		player = new Player(spawn.getX(), spawn.getY(), input);

		menu = new MainMenu(input);
		state = State.GAMEOVER;
		countdown = new Timer(30);

		bg_image = bg_img.loadImage("/menu.png");

		addKeyListener(input);
	}

	private void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	private void init() {
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void run() {
		init();
		long lastTime = System.nanoTime();
		double amountOfUpdates = 60.0;
		double ns = 1000000000 / amountOfUpdates;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;

				if (state == State.GAME) countdown.update();
			}
		}
	}

	private void update() {
		input.update();

		if (state == State.MENU || state == State.GAMEOVER) {
			menu.update();
		}

		if (state == State.GAME) {
			if (countdown.seconds <= 0) {
				state = State.GAMEOVER;
				menu = new GameOverMenu(input);
				countdown.seconds = 30;
			} else if (Mob.completed) {
				level.update();
			} else {
				player.update();
				level.update();
			}

		}

	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		render.clear();

		if (state == State.MENU || state == State.GAMEOVER) {
			g.drawImage(bg_image, 0, 0, getWidth(), getHeight(), null);
			menu.render(g);
		}

		if (state == State.GAME) {
			int xScroll = player.x - render.width / 2;
			int yScroll = player.y - render.height / 2;
			level.render(xScroll, yScroll, render);
			player.render(render);

			if (!Mob.completed) {
				g.setFont(new Font("Verdana", 0, 35));
				g.setColor(Color.BLACK);
				g.drawString("Power Level: " + countdown.seconds, 517, 42);
				g.setColor(Color.WHITE);
				g.drawString("Power Level: " + countdown.seconds, 515, 40);
			}

			if (Mob.completed) {
				countdown.seconds = 30;
				g.setColor(Color.BLACK);
				g.setFont(new Font("Verdana", 0, 75));
				g.drawString("You Win!", 438, 203);
				g.setColor(Color.WHITE);
				g.setFont(new Font("Verdana", 0, 75));
				g.drawString("You Win!", 435, 200);

				g.setColor(Color.WHITE);
				g.setFont(new Font("Verdana", 0, 35));
				String[] text = {
					" Congratulations! You have succeeded!", //
					"    Resulting in the city not being mad.", //
					"", //
					"", //
					"", //
					"", //
					"", //
					"         Created for Ludum Dare 39!", //
				};
				for (int i = 0; i < text.length; i++) {
					g.setColor(Color.BLACK);
					g.drawString(text[i], 290, 273 + i * 42);
					g.setColor(Color.WHITE);
					g.drawString(text[i], 287, 270 + i * 42);
				}
			}
		}

		for (int i = 0; i < pixels.length; i++)
			pixels[i] = render.pixels[i];

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game().start();
	}

}
