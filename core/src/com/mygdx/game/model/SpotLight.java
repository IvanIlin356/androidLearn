package com.mygdx.game.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by inilin on 18.08.2017.
 */

public class SpotLight {
    Vector2 position;
    int radius;

    public  SpotLight(Vector2 pos, int rad){
        this.position = pos;
        this.radius = rad;
    }
}
