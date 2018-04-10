package com.meio.materi;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class WebviewAud extends AppCompatActivity {

    WebView webview;
    String audlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_aud);
        audlink = getIntent().getExtras().getString("audlink");
        String link = getIntent().getExtras().getString("link");
        webview = (WebView) findViewById(R.id.view1);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setDisplayZoomControls(false);

        webview.loadUrl(link);
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

    public void aud(View view) {
        startSound(audlink);
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        if(mMediaPlayer!=null && mMediaPlayer.isPlaying()){//If music is playing already
            mMediaPlayer.stop();//Stop playing the music
        }

    }
}
