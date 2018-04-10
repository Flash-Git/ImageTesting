package dev.flash.imagetesting;

import java.awt.*;

/**
 * Created by Flash on 09/04/2018.
 */

public class Pixel {

	private int x, y;

	private Color color;

	public Pixel(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 1 * 32, 1 * 32);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
}
