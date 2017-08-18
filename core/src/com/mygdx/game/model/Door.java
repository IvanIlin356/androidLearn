package com.mygdx.game.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by inilin on 18.08.2017.
 */

public class Door {
    Vector2 position;
    int width, height;

    public Door (Vector2 pos, int width, int height){
        this.position = pos;
        this.width = width;
        this.height = height;
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
