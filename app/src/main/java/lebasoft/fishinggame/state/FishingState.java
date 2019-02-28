package lebasoft.fishinggame.state;

import android.view.MotionEvent;

import lebasoft.fishinggame.main.Assets;
import lebasoft.fishinggame.util.Painter;
import lebasoft.fishinggame.util.UIbutton;

public class FishingState extends State {

    //Buttons
    public UIbutton fishButton;
    public UIbutton boatButton;

    @Override
    public void init() {
        boatButton = new UIbutton(100,30,203,60, Assets.boatButton, Assets.boatButton);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Painter g) {
        g.drawImage(Assets.fishing, 0, 0);
        boatButton.render(g);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            //Buttons
            boatButton.onTouchDown(scaledX, scaledY);
        }

        if(e.getAction() == MotionEvent.ACTION_UP) {
            if (boatButton.isPressed(scaledX, scaledY)) {
                setCurrentState(new BoatState());
            }
        }
        return true;
    }
}
