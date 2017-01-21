package screens;

import com.mygdx.game.tut.TutorialClickerGame;
import com.mygdx.game.tut.entities.Player;

public class GameplayScreen extends AbstractScreen {

    private Player player;

    public GameplayScreen(TutorialClickerGame game) {
        super(game);
        init();
    }

    private void init() {
        initPlayer();
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        stage.act();
    }

    @Override
    public void dispose() {

    }
}
