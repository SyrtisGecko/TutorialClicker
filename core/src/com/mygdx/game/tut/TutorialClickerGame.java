package com.mygdx.game.tut;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.SplashScreen;

public class TutorialClickerGame extends Game {

	public final static String GAME_PREFS = "com.mygdx.game.tut.prefs";
	public final static String GAME_SCORE = "com.mygdx.game.tut.prefs.score";

	public final static String GAME_NAME = "Tutorial Clicker";

	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private boolean paused;

	private Preferences prefs;

	private int points;

	
	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
	}

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
	}

	public void addPoint() {
		points++;
		updateSavedScore();
	}

	private void updateSavedScore() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}

	/**
	 * getters setters
	 * @return
     */
	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public int getPoints() {
		return points;
	}

	public void resetGameScore() {
		points = 0;
		updateSavedScore();
	}
}
