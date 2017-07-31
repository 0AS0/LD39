package com.its0as0.ld39.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite voidSprite = new Sprite(16, 0x154CA5);
	public static Sprite block = new Sprite(16, 0xC0C0C0);
	public static Sprite source = new Sprite(16, 0x0000FF);
	public static Sprite destination = new Sprite(16, 0xFF0000);

	public static Sprite player = new Sprite(16, 0xffff00);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int col) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(col);
	}

	private void setColor(int col) {
		for (int i = 0; i < SIZE * SIZE; i++)
			pixels[i] = col;
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
