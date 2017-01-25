package service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Przemek on 2017-01-25.
 */
public class SoundService {

    private Sound moneySound;

    private Music music;

    public SoundService() {
        init();
    }

    private void init() {
        moneySound = Gdx.audio.newSound(Gdx.files.internal("sound/dropmetalthing.ogg"));
        music = Gdx.audio.newMusic(Gdx.files.internal("sound/lassolady.ogg"));
        // TODO add other sound effects
    }

    public void playMoneySoud() {
        moneySound.play();
    }

    public void startPlayingMusic(boolean looping) {
        music.setVolume(0.5f);
        music.play();
        music.setLooping(looping);
    }
}
