package com.its0as0.ld39.level.tile;

import com.its0as0.ld39.graphics.Render;
import com.its0as0.ld39.graphics.Sprite;

public class BlockTile extends Tile {

	public BlockTile(Sprite sprite) {
		super(sprite);
	}

	public boolean solid() {
		return true;
	}

	public void render(int x, int y, Render render) {
		render.renderTile(x << 4, y << 4, this);
	}

}
