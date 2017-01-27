package com.mygdx.game.tut.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;

public class RandomEventController {

    private final int RANDOM_TICK_INTERVAL = 5; // TODO change after implementation

    public RandomEventController() {
        init();
    }

    private void init() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if(MathUtils.randomBoolean()) {
                    triggerRandomEvent();
                }
            }
        }, RANDOM_TICK_INTERVAL, RANDOM_TICK_INTERVAL);
    }

    private void triggerRandomEvent() {
        System.out.println("Random event triggered.");
    }
}
