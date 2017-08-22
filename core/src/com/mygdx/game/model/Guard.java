package com.mygdx.game.model;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by inilin on 22.08.2017.
 */

public class Guard {
    final static float SIZE = 10f;
    final static float SPEED = 40f;
    State state;
    Vector2 position;
    Circle guardBound;

    public enum State {
        onDuty, WORK
    }

    public Guard(Vector2 pos){
        this.position = pos;
        this.guardBound = new Circle(pos, SIZE);
        this.state = State.onDuty;
    }

    public void update(float delta) {
        switch (state) {
            case onDuty:
                break;
            case WORK:
                break;
        }


    }



}
