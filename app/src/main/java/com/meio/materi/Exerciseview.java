package com.meio.materi;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Exerciseview extends AppCompatActivity {

    String input,phonetic,aud,speech;
    TextView tinput,tdeskripsi;

    protected static final int RESULT_SPEECH = 1;

    private ImageButton btnSpeak;
    private TextView txtText;
    private TextView txtText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exerciseview);
        input=getIntent().getStringExtra("input");
        tinput = (TextView)findViewById(R.id.textView3);
        tinput.setText(input);


        //akses dc
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        phonetic=databaseAccess.getph(input);
        aud = databaseAccess.getaud(input);
        databaseAccess.close();

        tdeskripsi = (TextView)findViewById(R.id.textView4);
        tdeskripsi.setText(phonetic);

        txtText = (TextView) findViewById(R.id.textView);
        txtText2 = (TextView) findViewById(R.id.textView2);

        btnSpeak = (ImageButton) findViewById(R.id.imageButton);

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    txtText.setText("");
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Opps! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }


            }



        });



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
        startSound(aud);
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        if(mMediaPlayer!=null && mMediaPlayer.isPlaying()){//If music is playing already
            mMediaPlayer.stop();//Stop playing the music
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    speech = text.get(0);
                    speech = speech.toUpperCase();
                    txtText.setText(speech);

                    if (input.equals(speech)){
                        txtText2.setText("Correct");
                        txtText2.setTextColor(0xFF00FF00);
                    }
                    else {
                        txtText2.setText("Wrong");
                        txtText2.setTextColor(0xFFFF0000);
                    }
                }
                break;
            }

        }
    }
}
