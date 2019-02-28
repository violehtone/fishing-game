package lebasoft.fishinggame.model;

import android.graphics.Rect;

/**
 * Created by ville.lehtonen on 27/02/2019.
 */

public class Boat {

    private float x, y;
    private int width, height;
    private float velX, velY;
    private Rect rect;
    private static final int MOVE_SPEED = 10;


    public Boat(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new Rect();
        velX = 0;
        velY = 0;
    }

    public void update(float delta) {
        //Update player's x and y coordinates:
        x += velX;
        y += velY;
        updateRects();
    }

    public void updateRects() {
        rect.set((int) x , (int) y , (int)(x +  width), (int) (y + height));
    }

    public void accelLeft() {
        velX = -MOVE_SPEED;
    }
    public void accelRight() {
        velX = MOVE_SPEED;
    }
    public void accelUp() {velY = -MOVE_SPEED;}
    public void accelDown() {velY = MOVE_SPEED;}
    public void stop() {
        velX = 0;
        velY = 0;
    }

    public float getX() {return x;}
    public float getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public Rect getRect() {return rect;}


}
