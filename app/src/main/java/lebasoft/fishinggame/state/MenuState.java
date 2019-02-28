package lebasoft.fishinggame.state;

import android.view.MotionEvent;

import lebasoft.fishinggame.util.Painter;
import lebasoft.fishinggame.main.Assets;
import lebasoft.fishinggame.util.UIbutton;

public class MenuState extends State {

    public UIbutton newGameButton;

    @Override
    public void init() {
        newGameButton = new UIbutton(450, 200, 650, 300, Assets.newGameButton, Assets.newGameButton);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Painter g) {
        g.drawImage(Assets.menuScreen, 0, 0);
        newGameButton.render(g);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            newGameButton.onTouchDown(scaledX, scaledY);
        }

        if (e.getAction() == MotionEvent.ACTION_UP) {
            if (newGameButton.isPressed(scaledX, scaledY)) {
                setCurrentState(new BoatState());
            }
        }
        return true;
    }
}
