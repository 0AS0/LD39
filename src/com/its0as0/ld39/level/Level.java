package com.its0as0.ld39.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.its0as0.ld39.graphics.Render;
import com.its0as0.ld39.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tiles;

	public static Level level = new MainLevel();

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(MainLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			System.out.println("Exception! Could not load level file!");
			e.printStackTrace();
		}
	}

	public void update() {
	}

	public void render(int xScroll, int yScroll, Render render) {
		render.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + render.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + render.height + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, render);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.COL_BLOCK) return Tile.block;
		if (tiles[x + y * width] == Tile.COL_SOURCE) return Tile.source;
		if (tiles[x + y * width] == Tile.COL_DESTINATION) return Tile.destination;
		return Tile.voidTile;
	}

}
