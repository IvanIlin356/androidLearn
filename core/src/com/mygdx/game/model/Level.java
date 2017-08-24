package com.mygdx.game.model;

/**
 * Created by inilin on 23.08.2017.
 */

public class Level {
    int number, aliensCountInWave, waveDuration;
    float aliensFreaquency;

    public void levelInit(int number) {
        this.number = number; // пока тока 1й уровень
        //this.wavesCount = 3;
        this.waveDuration = 30; //sec
        this.aliensCountInWave = 10;
        aliensFreaquency = waveDuration / aliensCountInWave;
    }

    public int getNumber() {
        return number;
    }

    public int getAliensCountInWave() {
        return aliensCountInWave;
    }

    public float getAliensFreaquency() {
        return aliensFreaquency;
    }
}
