package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by inilin on 18.08.2017.
 */

public class SpotLight {
    Vector2 position;
    int radius;
    Circle spotLightBound;

    public  SpotLight(Vector2 pos, int rad){
        this.position = pos;
        this.radius = rad;
        this.spotLightBound = new Circle(pos, rad);
    }

    public void update(Vector2 newDirection){
        position.add(newDirection.x * Gdx.graphics.getDeltaTime(), newDirection.y * Gdx.graphics.getDeltaTime());
        spotLightBound.set(position.x, position.y, radius);
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
}
