package com.mygdx.game.model;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;

/**
 * Created by inilin on 22.08.2017.
 */

public class Guard {
    public final static float SIZE = 10f;
    final static float SPEED = 40f;
    final static int STEPS = 60;
    State state;
    Vector2 position;
    Vector2 alienDirection;
    Alien spottedAlien;
    Circle guardBound;
    boolean isLeft;
    int steps;
    int damage;

    public enum State {
        onDUTY, WORK
    }

    public Guard(Vector2 pos){
        this.position = pos;
        this.guardBound = new Circle(pos, SIZE);
        this.state = State.onDUTY;
        this.isLeft = true;
        this.steps = 0;
        this.spottedAlien = new Alien(new Vector2(0,0));
        this.alienDirection = new Vector2();
        this.damage = 2;
    }

    public void update(float delta) {
        switch (state) {
            case onDUTY:
                if (isLeft){
                    position.x -= (SPEED / 4) * delta;
                    if (steps++ >= STEPS){
                        isLeft = false;
                        steps = -STEPS;
                    }
                }
                else {
                    position.x += (SPEED / 4) * delta;
                    if (steps++ >= STEPS) {
                        isLeft = true;
                        steps = -STEPS;
                    }
                }
                break;
            case WORK:
                alienDirection.set(spottedAlien.position.x - position.x, spottedAlien.position.y - position.y).nor().scl(SPEED);
                position.add(alienDirection.x * delta, alienDirection.y * delta);
                break;
        }
        guardBound.set(position, SIZE);
    }

    public void hitAlien(Alien alien){
        alien.incHealth(damage);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Circle getGuardBound() {
        return guardBound;
    }

    public Alien getSpottedAlien() {
        return spottedAlien;
    }

    public void setSpottedAlien(Alien spottedAlien) {
        this.spottedAlien = spottedAlien;
    }
}
