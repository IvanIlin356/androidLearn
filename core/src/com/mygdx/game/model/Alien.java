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
    int health;
    boolean isSpoted;
    boolean isAlive;

    public  Alien(Vector2 pos) {
        this.position = pos;
        this.alienBound = new Circle(pos.x, pos.y, SIZE);
        this.isSpoted = false;
        this.health = 10;
        this.isAlive = true;
    }

    public void update(float delta) {
        this.position.y -= 30 * delta;
        this.alienBound.set(position.x, position.y, SIZE);
    }

    public int getHealth() {
        return health;
    }

    public void incHealth(int damage){
        health -= damage;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Circle getAlienBound() {
        return alienBound;
    }

    public boolean isSpoted() {
        return isSpoted;
    }

    public void setSpoted(boolean spoted) {
        isSpoted = spoted;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
