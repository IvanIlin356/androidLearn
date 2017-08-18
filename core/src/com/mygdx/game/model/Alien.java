package com.mygdx.game.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alien on 12.08.2017.
 */

public class Alien {
    final public static float SIZE = 10f;

    Vector2 position = new Vector2();

    public  Alien(Vector2 pos) {
        this.position = pos;
    }

    public void update(float delta) {
        this.position.y -= 30 * delta;
    }

    public Vector2 getPosition() {
        return position;
    }

}
