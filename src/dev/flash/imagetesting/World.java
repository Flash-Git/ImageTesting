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

	public static int PIXEL_SIZE = 16;

	private ArrayList<LineGenerator> lineGenerators;

	public World(Handler handler, int width, int height) {
		this.handler = handler;
		this.width = width;
		this.height = height;
	}

	public void init() {
		pixelManager = new PixelManager(handler);
		lineGenerators = new ArrayList<>();
	}

	public void tick(double delta) {
		lineGenerators.removeIf(generator -> generator.isDone());
		if(lineGenerators.size() < 8) {
			lineGenerators.add(new LineGenerator(handler, new Random().nextInt(width) / PIXEL_SIZE * PIXEL_SIZE, new Random().nextInt(height) / PIXEL_SIZE * PIXEL_SIZE, new Random().nextInt(width) / PIXEL_SIZE * PIXEL_SIZE, new Random().nextInt(height) / PIXEL_SIZE * PIXEL_SIZE, 3));
		}
		for(LineGenerator generator : lineGenerators) {
			generator.tick(delta);
		}
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
