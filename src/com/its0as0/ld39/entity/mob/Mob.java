package com.its0as0.ld39.entity.mob;

import com.its0as0.ld39.entity.Entity;
import com.its0as0.ld39.graphics.Sprite;
import com.its0as0.ld39.level.tile.DestinationTile;

public class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	public static boolean completed = false;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (xa > 0) dir = 0;
		if (xa < 0) dir = 1;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 3;

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public void update() {
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + (c % 2 * 2 - 3) * 5) >> 4;
			int yt = ((y + ya) + (c / 2 * 2 - 13) * 2) >> 4;
			if (level.getTile(xt, yt + 1).solid()) solid = true;
			if (level.getTile(xt, yt + 1) instanceof DestinationTile) completed = true;
		}

		return solid;
	}

	public void render() {
	}

}
