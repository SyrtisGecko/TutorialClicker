package screens;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.tut.TutorialClickerGame;
import com.sun.org.apache.xml.internal.security.Init;

/**
 * Created by Przemek on 2017-01-19.
 */
public class SplashScreen extends AbstractScreen {

    private Texture splashImg;

    public SplashScreen(TutorialClickerGame game) {
        super(game);
        init();
    }

    private void init() {
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
