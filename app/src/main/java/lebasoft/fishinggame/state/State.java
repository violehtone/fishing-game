package lebasoft.fishinggame.state;

import android.view.MotionEvent;

import lebasoft.fishinggame.util.Painter;
import lebasoft.fishinggame.main.MainActivity;

public abstract class State {

    public void setCurrentState(State newState) {
        MainActivity.game.setCurrentState(newState);
    }

    public abstract void init();

    public abstract void update(float delta);

    public abstract void render(Painter g);

    public abstract boolean onTouch(MotionEvent e, int scaledX, int scaledY);

    public void onResume() {}
    public void onPause() {}
}
