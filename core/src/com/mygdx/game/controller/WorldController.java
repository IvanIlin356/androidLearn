package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.model.Alien;
import com.mygdx.game.model.Guard;
import com.mygdx.game.model.World;

/**
 * Created by alien on 12.08.2017.
 */

public class WorldController {
    World world;
    boolean isGuardOnWork = false;
    long lastHitTime;

    public WorldController(World world){
        this.world = world;
    }

    public void update (float delta) {

        world.getSpotLight().update(delta);

        if (world.getAliens() != null) {
            isGuardOnWork = false;
            for (int i = 0; i < world.getAliens().size; i++) {
                world.getAliens().get(i).update(delta);

                if ((Math.abs(world.getSpotLight().getPosition().y - world.getAliens().get(i).getPosition().y) <= world.getSpotLight().getRadius() + Alien.SIZE) &&
                        (Math.abs(world.getSpotLight().getPosition().x - world.getAliens().get(i).getPosition().x) <= world.getSpotLight().getRadius() + Alien.SIZE)) {
                        if (Intersector.overlaps(world.getAliens().get(i).getAlienBound(), world.getSpotLight().getSpotLightBound())) {
                            world.getAliens().get(i).setSpoted(true);
                            world.getGuard().setState(Guard.State.WORK);
                            world.getGuard().setSpottedAlien(world.getAliens().get(i));
                            isGuardOnWork = true;
                            if (TimeUtils.nanoTime() - lastHitTime > world.getGuard().getAttackSpeed()) {
                                if (Intersector.overlaps(world.getAliens().get(i).getAlienBound(), world.getGuard().getGuardBound())) {
                                    world.getGuard().hitAlien(world.getAliens().get(i));
                                    lastHitTime = TimeUtils.nanoTime();
                                }
                            }
                        }
                }
                else {
                    world.getAliens().get(i).setSpoted(false);
                    //if (!isGuardOnWork) world.getGuard().setState(Guard.State.onDUTY);
                }

                if (world.getAliens().get(i).getPosition().y - Alien.SIZE <= world.getDoor().getPosition().y + world.getDoor().getHeight()) {
                    if (Intersector.overlaps(world.getAliens().get(i).getAlienBound(), world.getDoor().getDoorBound())) {
                        world.getAliens().get(i).setAlive(false);
                    }
                }

                if (world.getAliens().get(i).getHealth() <= 0) world.getAliens().get(i).setAlive(false);

                if (!world.getAliens().get(i).isAlive()) world.deleteAlien(i);
            }
            if (!isGuardOnWork) world.getGuard().setState(Guard.State.onDUTY);
        }

        world.getGuard().update(delta);
    }
}
