package dev.flash.imagetesting;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Flash on 09/04/2018.
 */

public class PixelManager {

	public ArrayList<Pixel> all;
	public ArrayList<Pixel> toRemove;

	public Handler handler;


	public PixelManager(Handler handler) {
		this.handler = handler;
		all = new ArrayList<>();
		toRemove = new ArrayList<>();
	}

	public boolean add() {
		int x = new Random().nextInt(handler.getWorldWidth() / 32);
		int y = new Random().nextInt(handler.getWorldHeight() / 32);
		for(Pixel p : all) {
			if(p.getX() == x && p.getY() == y) {
				toRemove.add(p);
			}
		}
		all.add(new Pixel(x, y, new Color(new Random().nextInt(25) + 30, new Random().nextInt(25) + 30, new Random().nextInt(25) + 30)));
		all.removeAll(toRemove);
		return true;
	}

	public boolean add(int x, int y) {
		for(Pixel p : all) {
			if(p.getX() == x && p.getY() == y) {
				toRemove.add(p);
			}
		}
		all.add(new Pixel(x, y, new Color(new Random().nextInt(25) + 30, new Random().nextInt(25) + 30, new Random().nextInt(25) + 30)));
		all.removeAll(toRemove);
		return true;
	}

	public void tick(double delta) {
	}

	public void render(Graphics g) {
		for(Pixel p : all) {
			p.render(g);
		}
	}
}
