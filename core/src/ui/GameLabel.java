package ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Przemek on 2017-01-22.
 */
public class GameLabel extends Label {

    public GameLabel() {
        super("", prepareLabelStyle());
        init();
    }

    private void init() {
        this.setX(20);
        this.setY(630);
    }

    private static LabelStyle prepareLabelStyle() {
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = new BitmapFont();
        return labelStyle;
    }
}
