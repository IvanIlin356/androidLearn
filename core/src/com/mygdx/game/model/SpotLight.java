package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by inilin on 18.08.2017.
 */

public class SpotLight {
    static final float SPEED = 70f;

    Vector2 position;
    int radius;
    Circle spotLightBound;
    Vector2 newDirection;

    public  SpotLight(Vector2 pos, int rad){
        this.position = pos;
        this.radius = rad;
        this.spotLightBound = new Circle(pos, rad);
        this.newDirection = new Vector2(0,0);
    }

    public void update(float delta){
        position.add(newDirection.x * delta, newDirection.y * delta);
        spotLightBound.set(position.x, position.y, radius);
    }

    public void stopSpotLight(){
        newDirection.set(0,0);
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getRadius() {
        return radius;
    }

    public Circle getSpotLightBound() {
        return spotLightBound;
    }

    public void setNewDirection(Vector2 newDirection) {
        this.newDirection = newDirection.scl(SPEED);
    }
}
