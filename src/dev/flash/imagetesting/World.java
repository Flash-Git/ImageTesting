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


	private ArrayList<LineGenerator> lineGenerators;

	public World(Handler handler, int width, int height) {
		this.handler = handler;
		this.width = width;
		this.height = height;
	}

	public void init() {
		pixelManager = new PixelManager(handler);
		lineGenerators = new ArrayList<>();
		lineGenerators.add(new LineGenerator(handler, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, 5));
		lineGenerators.add(new LineGenerator(handler, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, 10));
		lineGenerators.add(new LineGenerator(handler, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, 15));
		lineGenerators.add(new LineGenerator(handler, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, 20));
	}

	public void tick(double delta) {
		lineGenerators.removeIf(generator -> generator.isDone());
		if(lineGenerators.size()<5){
			lineGenerators.add(new LineGenerator(handler, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, new Random().nextInt(width) / 32 * 32, new Random().nextInt(height) / 32 * 32, new Random().nextInt(100)));
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
