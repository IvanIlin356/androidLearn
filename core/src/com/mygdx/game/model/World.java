package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alien on 12.08.2017.
 */

public class World {
    Array<Alien> aliens;

    public World(){
        this.aliens = new Array<Alien>();
    }

    public void addAlien(Vector2 pos){
        aliens.add(new Alien(pos));
        Gdx.app.log("alien added", pos.x + " " + pos.y);
    }

    public Array<Alien> getAliens() {
        return aliens;
    }
}
