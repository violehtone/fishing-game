package lebasoft.fishinggame.state;

import android.view.MotionEvent;

import lebasoft.fishinggame.util.Painter;
import lebasoft.fishinggame.main.Assets;

public class LoadState extends State {

    @Override
    public void init() {
        Assets.load();
    }

    @Override
    public void update(float delta) {
        setCurrentState(new MenuState());
    }

    @Override
    public void render(Painter g) {

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        return false;
    }
}
