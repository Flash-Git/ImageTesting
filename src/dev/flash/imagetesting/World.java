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

    public World(Handler handler, int width, int height) {
        this.handler = handler;
        this.width = width;
        this.height = height;
    }

    public void init() {
    	pixelManager = new PixelManager(handler);
    }

    public void tick(double delta) {
        pixelManager.add();
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
