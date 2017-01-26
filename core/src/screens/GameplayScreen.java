package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.tut.TutorialClickerGame;
import com.mygdx.game.tut.controllers.FlyingObjectController;
import com.mygdx.game.tut.entities.Player;
import service.PassiveIncomeService;
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
    private FlyingObjectController flyingObjectController;
    private PassiveIncomeService passiveIncomeService;

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
        initFlyingObjectController();
        startTheMusic();
        initPassiveIncomeService();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    @Override
    public void pause() {
        super.pause();
        game.getScoreService().saveCurrentTimestamp();
        // TODO make flush() of ScoreService always on pause()
    }

    private void update() {
        scoreLabel.setText("Score: " + game.getScoreService().getPoints());
        stage.act();
    }

    private void initPassiveIncomeService() {
        passiveIncomeService = new PassiveIncomeService(game.getScoreService());
        passiveIncomeService.start();
    }

    private void startTheMusic() {
        game.getSoundService().startPlayingMusic(true);
    }

    private void initFlyingObjectController() {
        flyingObjectController = new FlyingObjectController(game, stage);
    }

    private void initBg() {
        bgImg = new Image(new Texture("desert-background.png"));
        stage.addActor(bgImg);
    }

    private void initResetScoreButton() {
        resetScoreButton = new ResetScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.getScoreService().resetGameScore();
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
                game.getScoreService().addPoint();
            }
        });

        stage.addActor(playerButton);
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    @Override
    public void dispose() {

    }
}
