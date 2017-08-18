package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.Alien;
import com.mygdx.game.model.World;

/**
 * Created by alien on 12.08.2017.
 */

public class WorldController {
    World world = new World();

    public WorldController(World world){
        this.world = world;
    }

    public void update (float delta) {
        if (world.getAliens() != null) {
            for (Alien alien : world.getAliens()) {
                alien.update(delta);
                if (alien.getPosition().y - Alien.SIZE <= world.getDoor().getPosition().y + world.getDoor().getHeight()) {
                    Gdx.app.log("alien delete", "");
                    world.deleteAlien(alien);
                }
            }
        }
    }
}
