package lebasoft.fishinggame.state;

import android.view.MotionEvent;

import lebasoft.fishinggame.main.Assets;
import lebasoft.fishinggame.main.MainActivity;
import lebasoft.fishinggame.model.Boat;
import lebasoft.fishinggame.util.Painter;
import lebasoft.fishinggame.util.UIbutton;

public class BoatState extends State {

    //Models
    private Boat boat;

    //Buttons
    public UIbutton fishButton;

    //Variables
    private static final int PLAYER_WIDTH = 108;
    private static final int PLAYER_HEIGHT = 72;

    @Override
    public void init() {
        fishButton = new UIbutton(100,30,203,60, Assets.fishButton, Assets.fishButton);
        boat = new Boat(MainActivity.GAME_WIDTH/2,MainActivity.GAME_HEIGHT-200, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    @Override
    public void update(float delta) {
        boat.update(delta);
    }

    @Override
    public void render(Painter g) {
        g.drawImage(Assets.moving, 0, 0);
        fishButton.render(g);
        g.drawImage(Assets.boat, (int) boat.getX(), (int) boat.getY(), PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            //Buttons
            fishButton.onTouchDown(scaledX, scaledY);

            //Boat movement
            if (scaledY < boat.getY() - 10 || scaledY > boat.getY() + PLAYER_HEIGHT + 10) {
                //Vertical movement
                if (scaledY < boat.getY()) {
                    boat.accelUp();
                } else {
                    boat.accelDown();
                }
            } else {
                //Horizontal movement
                if (scaledX > boat.getX() + PLAYER_WIDTH) {
                    boat.accelRight();
                } else if (scaledX < boat.getX()) {
                    boat.accelLeft();
                }
            }
        }

        if(e.getAction() == MotionEvent.ACTION_UP) {
            if (fishButton.isPressed(scaledX, scaledY)) {
                setCurrentState(new FishingState());
            }
            boat.stop();
        }

        return true;
    }
}
