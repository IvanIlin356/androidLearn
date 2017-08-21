package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
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
            for (int i = 0; i < world.getAliens().size; i++) {
                world.getAliens().get(i).update(delta);

                if (Math.abs(world.getSpotLight().getPosition().y - world.getAliens().get(i).getPosition().y) <= world.getSpotLight().getRadius() + Alien.SIZE) {
                    if (Math.abs(world.getSpotLight().getPosition().x - world.getAliens().get(i).getPosition().x) <= world.getSpotLight().getRadius() + Alien.SIZE) {
                        world.getAliens().get(i).setSpoted(true);
                    }
                }
                else world.getAliens().get(i).setSpoted(false);

                if (world.getAliens().get(i).getPosition().y - Alien.SIZE <= world.getDoor().getPosition().y + world.getDoor().getHeight()) {
                    if (Intersector.overlaps(world.getAliens().get(i).getAlienBound(), world.getDoor().getDoorBound())) {
                        Gdx.app.log("alien delete", "");
                        world.deleteAlien(i);
                    }
                }
            }
        }
    }
}
