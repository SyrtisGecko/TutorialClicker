package service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ScoreService {

    public final static String GAME_PREFS = "com.mygdx.game.tut.prefs";
    public final static String GAME_SCORE = "com.mygdx.game.tut.prefs.score";
    public final static String GAME_PASSIVE_INCOM = "com.mygdx.game.tut.prefs.passiveincome";

    private Preferences prefs;

    private int points;
    private int passiveIncome;
    
    public ScoreService() {
        init();
    }

    private void init() {
        prefs = Gdx.app.getPreferences(GAME_PREFS);
        loadScore();
        loadPassiveIncome();
    }

    private void loadScore() {
        points = prefs.getInteger(GAME_SCORE);
    }

    private void loadPassiveIncome() {
        passiveIncome = prefs.getInteger(GAME_PASSIVE_INCOM);
    }

    public void addPoints(int i) {
        points += i;
        updateSavedScoreAndPassiveIncome();
    }

    public void addPoint() {
        points++;
        updateSavedScoreAndPassiveIncome();
    }

    public void resetGameScore() {
        points = 0;
        passiveIncome = 0;
        updateSavedScoreAndPassiveIncome();
    }

    private void updateSavedScoreAndPassiveIncome() {
        prefs.putInteger(GAME_SCORE, points);
        prefs.putInteger(GAME_PASSIVE_INCOM, passiveIncome);
        prefs.flush();
    }

    public void addPassiveIncome() {
        passiveIncome++;
        updateSavedScoreAndPassiveIncome();
        System.out.println("Passive income:" + passiveIncome);
    }

    public int getPoints() {
        return points;
    }

    public int getPassiveIncome() {
        return passiveIncome;
    }
}
