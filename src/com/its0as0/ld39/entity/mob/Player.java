package com.its0as0.ld39.entity.mob;

import com.its0as0.ld39.Input;
import com.its0as0.ld39.graphics.Render;
import com.its0as0.ld39.graphics.Sprite;
import com.its0as0.ld39.level.Level;

public class Player extends Mob {

	private Input input;
	private Sprite sprite;
	private boolean walking;
	private int speed = 1;

	public Player(Input input) {
		this.input = input;
		init(Level.level);
		sprite = Sprite.player;
	}

	public Player(int x, int y, Input input) {
		this.x = x;
		this.y = y;
		this.input = input;
		init(Level.level);
		sprite = Sprite.player;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (input.up) ya -= speed;
		if (input.down) ya += speed;
		if (input.left) xa -= speed;
		if (input.right) xa += speed;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}

	public void render(Render render) {
		render.renderSprite(x - 16, y - 16, sprite, true);
	}

}
