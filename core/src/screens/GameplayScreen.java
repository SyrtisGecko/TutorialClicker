package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.tut.TutorialClickerGame;
import com.mygdx.game.tut.entities.FlyingObject;
import com.mygdx.game.tut.entities.Player;
import ui.IClickCallback;
import ui.PlayerButton;
import ui.ResetScoreButton;
import ui.ScoreLabel;

public class GameplayScreen extends AbstractScreen {

    private Image bgImg;
    private Player player;
    private ResetScoreButton resetScoreButton;
    private PlayerButton playerButton;
    private ScoreLabel scoreLabel;
    private FlyingObject flyingObject1;

    public GameplayScreen(TutorialClickerGame game) {
        super(game);
    }

    @Override
    protected void init() {
        initBg();
        initPlayer();
        initPlayerButton();
        initResetScoreButton();
        initScoreLabel();
        initFlyingObjects();
    }

    private void initFlyingObjects() {
        flyingObject1 = new FlyingObject(FlyingObject.MONEY);
        stage.addActor(flyingObject1);
        flyingObject1.flyLikeHell();
    }

    private void initBg() {
        bgImg = new Image(new Texture("desert-background.png"));
        stage.addActor(bgImg);
    }

    private void initResetScoreButton() {
        resetScoreButton = new ResetScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.resetGameScore();
            }
        });

        stage.addActor(resetScoreButton);

    }

    private void initScoreLabel() {
        scoreLabel = new ScoreLabel();
        stage.addActor(scoreLabel);
    }

    private void initPlayerButton() {
        playerButton = new PlayerButton(new IClickCallback() {
            @Override
            public void onClick() {
                player.reactOnClick();
                game.addPoint();
            }
        });

        stage.addActor(playerButton);

    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        System.out.println("Punkty: " + game.getPoints());

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        scoreLabel.setText("Score: " + game.getPoints());
        stage.act();
    }

    @Override
    public void dispose() {

    }
}
