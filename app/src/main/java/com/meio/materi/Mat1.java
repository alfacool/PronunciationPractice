package com.meio.materi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Mat1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat1);
    }

    public void mat1pt1 (View view) {
        Intent intent = new Intent(this, Webview.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART_1.htm");
        startActivity(intent);
    }

    public void mat1pt2(View view) {
        Intent intent = new Intent(this, Mat1Part2.class);
        startActivity(intent);
    }

    public void mat1pt3(View view) {
        Intent intent = new Intent(this, Mat1Part3.class);
        startActivity(intent);
    }

    public void mat1pt4(View view) {
        Intent intent = new Intent(this, Webview.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART_4.htm");
        startActivity(intent);
    }

    public void mat1pt5(View view) {
        Intent intent = new Intent(this, Webview.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART_5.htm");
        startActivity(intent);
    }

    public void mat1pt6(View view) {
        Intent intent = new Intent(this, Webview.class);
        intent.putExtra("link", "file:///android_asset/mat1/PART_6.htm");
        startActivity(intent);
    }

    public void mat1pt7 (View view) {
        Intent intent = new Intent(this, Mat1Part7.class);
        startActivity(intent);
    }
}
