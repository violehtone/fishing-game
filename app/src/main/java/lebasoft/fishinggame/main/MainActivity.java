package lebasoft.fishinggame.main;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends Activity {

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 450;
    public static GameView game;
    public static AssetManager assets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assets = getAssets();
        game = new GameView(this, GAME_WIDTH, GAME_HEIGHT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(game);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Assets.onResume();
        game.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Assets.onPause();
        game.onPause();
    }
}
