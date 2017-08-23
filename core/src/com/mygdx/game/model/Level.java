package com.mygdx.game.model;

/**
 * Created by inilin on 23.08.2017.
 */

public class Level {
    int number, wavesCount, aliensCountInWave;
    float aliensFreaquency;

    public Level(int number) {
        this.number = number; // пока тока 1й уровень
        this.wavesCount = 3;
        this.aliensCountInWave = 10;
        this.aliensFreaquency = 1f;
    }

    public int getNumber() {
        return number;
    }

    public int getWavesCount() {
        return wavesCount;
    }

    public int getAliensCountInWave() {
        return aliensCountInWave;
    }

    public float getAliensFreaquency() {
        return aliensFreaquency;
    }
}
