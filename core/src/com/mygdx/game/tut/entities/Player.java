package com.mygdx.game.tut.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Przemek on 2017-01-21.
 */
public class Player extends Image {

    private final static int WIDTH = 100;
    private final static int HEIGHT = 152;
    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 300;

    public Player() {
        super(new Texture("zdjecie.png"));

        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition(STARTING_X,STARTING_Y);
    }

    public void reactOnClick() {
        int xMoveAmmount = MathUtils.random(-130, 130);
        int yMoveAmmount = 10;  //MathUtils.random(-130, 130);
        float moveActionTime = 0.3f;
        Action moveAction = Actions.sequence(
                Actions.moveBy(xMoveAmmount, yMoveAmmount, moveActionTime, Interpolation.circleOut),
                Actions.moveBy(-xMoveAmmount, -yMoveAmmount, 0.30f, Interpolation.circle)
        );

        int xGrowAmmount = MathUtils.random(-30, 100);
        int yGrowAmmount = 20;  //MathUtils.random(-30, 100);
        float growActionTime = 0.2f;
        Action growAction = Actions.sequence(
                Actions.sizeBy(xGrowAmmount, yGrowAmmount, growActionTime, Interpolation.circleOut),
                Actions.sizeBy(-xGrowAmmount, -yGrowAmmount, growActionTime, Interpolation.circle)
        );

        this.addAction(moveAction);
        this.addAction(growAction);

        if(this.getHeight() > 170) {
            this.addAction(Actions.rotateBy(MathUtils.randomSign()*360, 0.4f));
        }
    }
}
