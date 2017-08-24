package com.mygdx.game.controller;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.Level;
import com.mygdx.game.model.World;
import com.mygdx.game.view.WorldRenderer;

import java.util.Random;

/**
 * Created by inilin on 23.08.2017.
 */

public class LevelController {
    World world;
    Level level;
    double lastAlienSpawn;
    Random startX;
    int aliensSpawned;

    public LevelController (World world){
        this.world = world;
        this.level = world.getLevel();
        //this.wave = 1;
        this.lastAlienSpawn = 0;
        this.startX = new Random();
        this.aliensSpawned = 0;
    }

    public void update(float delta){
        if (aliensSpawned <= level.getAliensCountInWave()) {
            if (lastAlienSpawn >= level.getAliensFreaquency()) {
                world.addAlien(new Vector2(startX.nextInt(379) + 51, WorldRenderer.worldHeight + 10));
                lastAlienSpawn = 0;
                aliensSpawned++;
            } else {
                lastAlienSpawn += delta;
            }
        }
    }
}
