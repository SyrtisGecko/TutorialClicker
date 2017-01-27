package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.tut.TutorialClickerGame;
import com.mygdx.game.tut.controllers.FlyingObjectController;
import com.mygdx.game.tut.controllers.RandomEventController;
import com.mygdx.game.tut.entities.Player;
import service.PassiveIncomeService;
import ui.*;

public class GameplayScreen extends AbstractScreen {

    private Image bgImg;
    private Player player;
    private ResetScoreButton resetScoreButton;
    private PlayerButton playerButton;
    private GameLabel scoreLabel;
    private FlyingObjectController flyingObjectController;
    private RandomEventController randomEventController;
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
        initPassiveIncomeInfoDialog();
        initRandomEventController();
    }

    private void initRandomEventController() {
        randomEventController = new RandomEventController(game);
    }

    private void initPassiveIncomeInfoDialog() {
        if(passiveIncomeService.getPointsToAdd() > 0) {
            BasicDialog basicDialog = new BasicDialog();
            stage.addActor(basicDialog);
            basicDialog.initContent("Passive income gained: " + passiveIncomeService.getPointsToAdd());
        }
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
        game.getScoreService().saveCurrentGameState();
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
        scoreLabel = new GameLabel();
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
