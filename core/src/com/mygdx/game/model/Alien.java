package com.mygdx.game.model;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alien on 12.08.2017.
 */

public class Alien {
    final public static float SIZE = 10f;

    Vector2 position = new Vector2();
    Circle alienBound;

    public  Alien(Vector2 pos) {
        this.position = pos;
        this.alienBound = new Circle(pos.x, pos.y, SIZE);
    }

    public void update(float delta) {
        this.position.y -= 30 * delta;
        this.alienBound.set(position.x, position.y, SIZE);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Circle getAlienBound() {
        return alienBound;
    }
}
