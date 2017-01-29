package com.mygdx.game.tut;

import com.badlogic.gdx.Game;
import screens.SplashScreen;
import service.FeatureFlagService;
import service.ScoreService;
import service.SoundService;

public class TutorialClickerGame extends Game {

	public final static String GAME_NAME = "Tutorial Clicker";

	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private SoundService soundService;
	private ScoreService scoreService;
	private FeatureFlagService featureFlagService;

	private boolean paused;

	
	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}

	private void init() {
		initSoundService();
		initScoreService();
		initFeatureFlagService();
	}

	private void initFeatureFlagService() {
		featureFlagService = new FeatureFlagService();
	}

	private void initScoreService() {
		scoreService = new ScoreService();
	}

	private void initSoundService() {
		soundService = new SoundService();
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

	public SoundService getSoundService() {
		return soundService;
	}

	public ScoreService getScoreService() {
		return scoreService;
	}

	public FeatureFlagService getFeatureFlagService() {
		return featureFlagService;
	}
}
