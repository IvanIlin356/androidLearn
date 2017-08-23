package com.mygdx.game.controller;

import com.mygdx.game.model.Level;
import com.mygdx.game.model.World;

/**
 * Created by inilin on 23.08.2017.
 */

public class LevelController {
    World world;
    Level level;
    int wave;
    double lastAlienSpawn;

    public LevelController (World world){
        this.world = world;
        this.level = world.getLevel();
        this.wave = 1;
    }

    public void update(){

    }
}
