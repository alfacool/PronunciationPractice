package com.meio.materi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pta(View view) {
        Intent intent = new Intent(this, Webview.class);
        intent.putExtra("link", "file:///android_asset/speech.htm");
        startActivity(intent);
    }
    public void ptb(View view) {
        Intent intent = new Intent(this, Webview.class);
        intent.putExtra("link", "file:///android_asset/ipa.htm");
        startActivity(intent);
    }


    public void pt1(View view) {
        Intent intent = new Intent(this, Mat1.class);
        startActivity(intent);
    }

    public void pt2 (View view) {
        Intent intent = new Intent(this, Mat2.class);
        startActivity(intent);
    }

    public void pt3(View view) {
        Intent intent = new Intent(this, Mat3.class);
        startActivity(intent);
    }


    public void pt4(View view) {

        Intent intent = new Intent(this, Listyt.class);
        startActivity(intent);
    }


    public void pt5(View view) {
        Intent intent = new Intent(this, STT.class);
        startActivity(intent);
    }


}
