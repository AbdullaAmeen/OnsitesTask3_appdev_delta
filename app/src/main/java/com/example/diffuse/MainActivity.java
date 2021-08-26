package com.example.diffuse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Display;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    layout_main view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Display display= getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Vibrator v = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);
        view = new  layout_main(this, size.y,size.x, v);
        setContentView(view);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        view.exit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        view.exit();
    }

}