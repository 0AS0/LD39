package com.its0as0.ld39.entity;

import com.its0as0.ld39.graphics.Render;
import com.its0as0.ld39.level.Level;

public abstract class Entity {

	public int x, y;
	public boolean removed = false;
	protected Level level;

	public void update() {
	}

	public void render(Render render) {
	}

	public void remove() {
		removed = true;
	}

	public void init(Level level) {
		this.level = level;
	}

}
