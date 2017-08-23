package com.mygdx.game.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by inilin on 18.08.2017.
 */

public class Joystick {
    Vector2 position;
    Vector2 newDirection;
    int radius;
    SpotLight spotLight;


    public Joystick(Vector2 pos, int rad, SpotLight spotLight){
        this.position = pos;
        this.radius = rad;
        this.newDirection = new Vector2(0,0);
        this.spotLight = spotLight;
    }

    public void touchDown(float touchX, float touchY){
        newDirection.set(touchX - position.x, touchY - position.y).nor();
        spotLight.setNewDirection(newDirection);
    }

    public void touchUp(){
        spotLight.stopSpotLight();
    }


    public Vector2 getPosition() {
        return position;
    }

    public int getRadius() {
        return radius;
    }
}
