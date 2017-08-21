package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by inilin on 18.08.2017.
 */

public class Joystick {
    Vector2 position;
    Vector2 newDirection;
    int radius;
    static final float SPEED = 10f;
    SpotLight spotLight;


    public Joystick(Vector2 pos, int rad, SpotLight spotLight){
        this.position = pos;
        this.radius = rad;
        this.newDirection = new Vector2(0,0);
        this.spotLight = spotLight;
    }

    public void touch(int touchX, int touchY){
        Gdx.app.log("joystick touched!", "");
        newDirection.x = touchX - position.x;
        newDirection.y = touchY - position.y;
        spotLight.update(newDirection);
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getRadius() {
        return radius;
    }
}
