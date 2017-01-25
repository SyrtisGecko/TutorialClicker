package service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Przemek on 2017-01-25.
 */
public class SoundService {

    private Sound moneySound;

    public SoundService() {
        init();
    }

    private void init() {
        moneySound = Gdx.audio.newSound(Gdx.files.internal("sound/dropmetalthing.ogg"));
    }

    public void playMoneySoud() {
        moneySound.play();
    }
}
