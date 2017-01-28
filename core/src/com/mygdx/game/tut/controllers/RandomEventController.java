package com.mygdx.game.tut.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.tut.TutorialClickerGame;

public class RandomEventController {

    private final int RANDOM_TICK_INTERVAL = 5; // TODO change after implementation

    private TutorialClickerGame game;

    private Stage stage;

    public RandomEventController(TutorialClickerGame game, Stage stage) {
        this.game = game;
        this.stage = stage;
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
        int randomNumber = MathUtils.random(1, 3);
        switch (randomNumber) {
            case 1:
                gainMoneyEvent();
                break;
            case 2:
                looseMoneyEvent();
                break;
            case 3:
                gainPassiveIncome();
                break;
            default:
                break;
        }
    }

    private void gainPassiveIncome() {
        game.getScoreService().addPassiveIncome();
        System.out.println("Gained passive income.");
    }

    private void looseMoneyEvent() {
        game.getScoreService().addPoints(-123);
        System.out.println("Lost money.");
    }

    private void gainMoneyEvent() {
        game.getScoreService().addPoints(123);
        System.out.println("Gained money.");
    }
}
