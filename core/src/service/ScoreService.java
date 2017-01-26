package service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.TimeUtils;

public class ScoreService {

    public final static String GAME_PREFS = "com.mygdx.game.tut.prefs";
    public final static String GAME_SCORE = "com.mygdx.game.tut.prefs.score";
    public final static String GAME_PASSIVE_INCOM = "com.mygdx.game.tut.prefs.passiveincome";
    public final static String GAME_SAVED_TIMESTAMP = "com.mygdx.game.tut.prefs.savedtimestamp";

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
    }

    public void addPoint() {
        points++;
    }

    public void resetGameScore() {
        points = 0;
        passiveIncome = 0;
    }

    public int getPoints() {
        return points;
    }

    public int getPassiveIncome() {
        return passiveIncome;
    }

    public long getSavedTimestamp() {
        return prefs.getLong(GAME_SAVED_TIMESTAMP);
    }

    public void addPassiveIncome() {
        passiveIncome++;
        System.out.println("Passive income:" + passiveIncome);
    }

    public void saveCurrentGameState() {
        prefs.putLong(GAME_SAVED_TIMESTAMP, TimeUtils.millis());
        prefs.putInteger(GAME_SCORE, points);
        prefs.putInteger(GAME_PASSIVE_INCOM, passiveIncome);
        prefs.flush();
    }
}
