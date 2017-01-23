package com.mygdx.game.tut.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.tut.TutorialClickerGame;
import com.mygdx.game.tut.entities.FlyingObject;

public class FlyingObjectController {

    private int spawnTime;

    public FlyingObjectController(TutorialClickerGame game, Stage stage) {
        init(game, stage);
    }

    private void init(final TutorialClickerGame game, final Stage stage) {
        randomizeSpawnTime();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        addRandomFlyingObjectToStage(game, stage);
                        randomizeSpawnTime();
                    }
                }, spawnTime);
            }
        }, 0, 5);
    }

    private void randomizeSpawnTime() {
        spawnTime = MathUtils.random(5, 10);
    }

    private void addRandomFlyingObjectToStage(TutorialClickerGame game, Stage stage) {
        FlyingObject flyingObject = null;

        if(MathUtils.randomBoolean()) {
            flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.MONEY, game);
        } else {
            flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.PASSIVE, game);
        }

        stage.addActor(flyingObject);
        flyingObject.flyLikeHell();
    }
}

