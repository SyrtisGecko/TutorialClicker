package ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AddAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class BasicDialog extends Image {

    private GameLabel label;

    private final static int WIDTH = 380;
    private final static int HEIGHT = 200;

    public BasicDialog() {
        super(new Texture("Menu_2.png"));

        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition(60,300);

        label = new GameLabel();
        label.setPosition(140, 400);

        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                fadeOutDialog();

                return super.touchDown(event, x, y, pointer, button);
            }
        });

    }

    public void initContent(String text) {
        label.setText(text);
        this.getStage().addActor(label);
    }

    private void fadeOutDialog() {
        SequenceAction sequence = Actions.sequence();
        sequence.addAction(Actions.fadeOut(1.5f));
        sequence.addAction(new AddAction() {
            @Override
            public boolean act(float delta) {
                BasicDialog.this.remove();
                label.remove();
                return false;
            }
        });
        this.addAction(sequence);
        label.addAction(Actions.fadeOut(1.5f));
    }
}
