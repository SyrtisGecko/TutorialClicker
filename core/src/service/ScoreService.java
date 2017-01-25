package service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Przemek on 2017-01-25.
 */
public class ScoreService {

    public final static String GAME_PREFS = "com.mygdx.game.tut.prefs";
    public final static String GAME_SCORE = "com.mygdx.game.tut.prefs.score";

    private Preferences prefs;

    private int points;
    
    public ScoreService() {
        init();
    }

    private void init() {
        prefs = Gdx.app.getPreferences(GAME_PREFS);
        loadScore();

    }

    private void loadScore() {
        points = prefs.getInteger(GAME_SCORE);
    }

    public void addPoints(int i) {
        points += i;
        updateSavedScore();
    }

    public void addPoint() {
        points++;
        updateSavedScore();
    }

    public void resetGameScore() {
        points = 0;
        updateSavedScore();
    }

    private void updateSavedScore() {
        prefs.putInteger(GAME_SCORE, points);
        prefs.flush();
    }

    public void addPassiveIncome() {
        // TODO implement
        System.out.println("Passive income click");
    }

    public int getPoints() {
        return points;
    }
}
