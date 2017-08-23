package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alien on 12.08.2017.
 */

public class World {
    Array<Alien> aliens;
    Door door;
    Joystick joystick;
    SpotLight spotLight;
    Guard guard;
    Level level;

    public World(Level level){
        this.door = new Door(new Vector2(50,200), 380, 30);
        this.spotLight = new SpotLight(new Vector2(240, 400), 50);
        this.joystick = new Joystick(new Vector2(400, 100), 75, spotLight);
        this.guard = new Guard(new Vector2(240, 250));
        this.aliens = new Array<Alien>();
        this.level = level;
    }

    public void deleteAlien(int i) {
        aliens.removeIndex(i);
    }

    public Array<Alien> getAliens() {
        return aliens;
    }

    public Door getDoor() {
        return door;
    }

    public Joystick getJoystick() {
        return joystick;
    }

    public SpotLight getSpotLight() {
        return spotLight;
    }

    public Guard getGuard() {
        return guard;
    }

    public Level getLevel() {
        return level;
    }
}
