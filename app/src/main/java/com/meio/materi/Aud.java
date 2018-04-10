package com.meio.materi;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Aud extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aud);
    }

    MediaPlayer mMediaPlayer = null;

    private void startSound(String assetName) {
        if(mMediaPlayer!=null && mMediaPlayer.isPlaying()){//If music is playing already
            mMediaPlayer.stop();//Stop playing the music
        }
        else {
            try {
                AssetFileDescriptor afd =  getAssets().openFd(assetName);
                mMediaPlayer = new MediaPlayer();
                mMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                afd.close();
                mMediaPlayer.prepare();
                mMediaPlayer.start();
            } catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void aud1(View view) {
        startSound("aud/1.mp3");
    }
    public void aud2(View view) {
        startSound("aud/2.mp3");
    }
    public void aud3(View view) {
        startSound("aud/3.mp3");
    }
    public void aud4(View view) {
        startSound("aud/4.mp3");
    }
    public void aud5(View view) {
        startSound("aud/5.mp3");
    }
    public void aud6(View view) {
        startSound("aud/6.mp3");
    }
    public void aud7(View view) {
        startSound("aud/7.mp3");
    }
    public void aud8(View view) {
        startSound("aud/8.mp3");
    }
    public void aud9(View view) {
        startSound("aud/9.mp3");
    }

}
