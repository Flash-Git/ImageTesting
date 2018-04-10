package dev.flash.imagetesting;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Flash on 10/03/2018.
 */


public class World {

	private int width, height;//in tiles

	private Handler handler;

	public PixelManager pixelManager;

	private LineGenerator lineGenerator;

	public World(Handler handler, int width, int height) {
		this.handler = handler;
		this.width = width;
		this.height = height;
	}

	public void init() {
		pixelManager = new PixelManager(handler);
		lineGenerator = new LineGenerator(handler, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, 100);
	}

	public void tick(double delta) {
		lineGenerator.tick(delta);
		pixelManager.tick(delta);
	}

	public void render(Graphics g) {
		pixelManager.render(g);
	}

	//GETTERS AND SETTERS

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
