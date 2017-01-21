package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.tut.TutorialClickerGame;
import com.sun.org.apache.xml.internal.security.Init;

/**
 * Created by Przemek on 2017-01-19.
 */
public class SplashScreen extends AbstractScreen {

    private Texture splashImg;

    public SplashScreen(final TutorialClickerGame game) {
        super(game);
        init();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                System.out.println("Poczekajmy 1 sekunde.");
                game.setScreen(new GameplayScreen(game));
            }
        }, 1);
    }

    @Override
    protected void init() {
        // TODO implement better assets loading
        splashImg = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        spriteBatch.draw(splashImg, 0 , 0);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
