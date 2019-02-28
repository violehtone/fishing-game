package lebasoft.fishinggame.main;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.io.IOException;
import java.io.InputStream;

public class Assets {

    private static SoundPool soundPool;
    public static Bitmap menuScreen, fishing, moving;
    public static Bitmap boat;
    public static Bitmap boatButton, fishButton, newGameButton;
    private static MediaPlayer mediaPlayer;


    public static void load() {
        menuScreen = loadBitmap("menu.jpg", false);
        fishing = loadBitmap("fishing.jpg", false);
        moving = loadBitmap("moving.jpg", false);
        boat = loadBitmap("boat.jpg", false);
        boatButton = loadBitmap("boatButton.jpg", false);
        fishButton = loadBitmap("fishButton.jpg", false);
        newGameButton = loadBitmap("newgamebutton.jpg", false);
    }

    private static Bitmap loadBitmap(String filename, boolean transparency) {
        InputStream inputStream = null;

        try {
            inputStream = MainActivity.assets.open(filename);
        }catch(IOException e) {
            e.printStackTrace();
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        if(transparency) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }else{
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }

        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, new BitmapFactory.Options());
        return bitmap;
    }

    private static int loadSound(String filename) {
        int soundId = 0;
        if(soundPool == null) {
            soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
        }
        try {
            soundId = soundPool.load(MainActivity.assets.openFd(filename), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return soundId;
    }

    public static void playSound(int soundId) {
        soundPool.play(soundId, 1, 1, 1, 0 , 1);
    }

    public static void playMusic(String filename, boolean looping) {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
        try {
            AssetFileDescriptor afd = MainActivity.assets.openFd(filename);
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepare();
            mediaPlayer.setLooping(looping);
            mediaPlayer.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void onResume() {
        playMusic("theme.wav", true);
    }

    public static void onPause() {
        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }

        if(mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
