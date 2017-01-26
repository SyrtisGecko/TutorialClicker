package service;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

import java.util.concurrent.TimeUnit;

public class PassiveIncomeService {

    private ScoreService scoreService;

    private final static int INFINITE = 100000;

    public PassiveIncomeService(ScoreService scoreService) {
        this.scoreService = scoreService;

        calculatePassiveIncome();
    }

    public void start() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                scoreService.addPoints(scoreService.getPassiveIncome());
            }
        }, 1, 1, INFINITE);
    }

    private void calculatePassiveIncome() {
        long savedTimestamp = scoreService.getSavedTimestamp();
        if(savedTimestamp > 0) {
            long millisPassed = TimeUtils.timeSinceMillis(savedTimestamp);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(millisPassed);
            System.out.println("Passed seconds: " + seconds);
            addPointBasedOnPassedTime(seconds);
        }
    }

    private void addPointBasedOnPassedTime(long seconds) {
        if(seconds > 0) {
            int points = ((int) (seconds * scoreService.getPassiveIncome())) / 10;
            System.out.println("Gained passive income: " + points);
            scoreService.addPoints(points);
        }
    }
}
