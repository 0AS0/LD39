package com.its0as0.ld39.level.tile;

import com.its0as0.ld39.graphics.Render;
import com.its0as0.ld39.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile block = new BlockTile(Sprite.block);
	public static Tile source = new SourceTile(Sprite.source);
	public static Tile destination = new DestinationTile(Sprite.destination);

	public static final int COL_BLOCK = 0xff808080;
	public static final int COL_SOURCE = 0xff0000FF;
	public static final int COL_DESTINATION = 0xffFF0000;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public boolean solid() {
		return false;
	}

	public void render(int x, int y, Render render) {
	}

}
