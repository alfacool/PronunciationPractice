package com.meio.materi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Mat1Part7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat1_part7);
    }

    public void mt1pt71 (View view) {
        Intent intent = new Intent(this, WebviewAud.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART7/1.htm");
        intent.putExtra("audlink", "aud/1.mp3");
        startActivity(intent);
    }

    public void mt1pt72 (View view) {
        Intent intent = new Intent(this, WebviewAud.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART7/2.htm");
        intent.putExtra("audlink", "aud/2.mp3");
        startActivity(intent);
    }

    public void mt1pt73 (View view) {
        Intent intent = new Intent(this, WebviewAud.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART7/3.htm");
        intent.putExtra("audlink", "aud/3.mp3");
        startActivity(intent);
    }

    public void mt1pt74 (View view) {
        Intent intent = new Intent(this, WebviewAud.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART7/4.htm");
        intent.putExtra("audlink", "aud/4.mp3");
        startActivity(intent);
    }

    public void mt1pt75 (View view) {
        Intent intent = new Intent(this, WebviewAud.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART7/5.htm");
        intent.putExtra("audlink", "aud/5.mp3");
        startActivity(intent);
    }

    public void mt1pt76 (View view) {
        Intent intent = new Intent(this, WebviewAud.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART7/6.htm");
        intent.putExtra("audlink", "aud/6.mp3");
        startActivity(intent);
    }

    public void mt1pt77 (View view) {
        Intent intent = new Intent(this, WebviewAud.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART7/7.htm");
        intent.putExtra("audlink", "aud/7.mp3");
        startActivity(intent);
    }

    public void mt1pt78 (View view) {
        Intent intent = new Intent(this, WebviewAud.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART7/8.htm");
        intent.putExtra("audlink", "aud/8.mp3");
        startActivity(intent);
    }

    public void mt1pt79 (View view) {
        Intent intent = new Intent(this, WebviewAud.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART7/9.htm");
        intent.putExtra("audlink", "aud/9.mp3");
        startActivity(intent);
    }
}
