package com.example.diffuse;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;

import com.example.diffuse.Objects.Box;
import com.example.diffuse.Objects.Paints;
import com.example.diffuse.Objects.Wire;
import com.example.diffuse.Objects.WireSet;

public class layout_main extends View {
    final static int STATE_START = -1, STATE_IN_GAME=1, STATE_GAME_OVER=0, STATE_PAUSE=-2;

    Box screen,minScreen;
    Paints paints;

    Box bt_restart, bt_play;
    WireSet wireSet;

    Vibrator v;
    private int score;
    private int gameState;


    public layout_main(Context context, float S_Height, float S_Width, Vibrator v) {
        super(context);
        this.v = v;
        screen = new Box(S_Height,S_Width,0,0);
        gameState = STATE_START;
        setGameParams();

    }

    private void setGameParams() {
        minScreen = new Box(screen.getCords().height()*0.6f, screen.getCords().width()*0.9f,screen.getCords().width()*0.05f,screen.getCords().height()*0.2f);
        bt_restart = new Box(100, 300, (int) (screen.getCords().width() - 300) / 2, (int)screen.getCords().height()/2);
        bt_play = new Box(100, 300, minScreen.getCords().centerX()-150,minScreen.getCords().bottom + 150);
        paints = new Paints();
    }
    

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(), y = event.getY();
        switch (gameState){
            case STATE_START:
                if (bt_play.getCords().contains((int) x, (int) y)) {
                    performClick();
                    startGame();
                }
                
                break;
            case STATE_IN_GAME:
                

                break;
            case STATE_GAME_OVER:
                

                break;
        }


        return true;

    }

    private void startGame() {
        gameState = STATE_IN_GAME;
        wireSet = new WireSet(minScreen);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {

            canvas.drawColor(Paints.colorBackGround);
            canvas.drawRect(minScreen.getCords(),paints.getPaintMinScreen());
            if(gameState == STATE_START) {
                canvas.drawRect(bt_play.getCords(), paints.getPaintButton());
                paints.writeTextCenter("Play",bt_play.getCords().centerX(),bt_play.getCords().centerY(),canvas,Paints.colorBackGround,32);
            }
           // canvas.drawRect(screen.getCords(),paints.getPaintMinScreen());
            if(gameState == STATE_IN_GAME) {
                for (Wire wireholder : wireSet.getWireHolderList()) {
                    canvas.drawRect(wireholder.getBox().getCords(), paints.getPaintHolder());
                }
                for (Wire wire : wireSet.getWireList()) {
                    paints.wireSetColor(wire.getColor());
                    canvas.drawRect(wire.getBox().getCords(), paints.getPaintWire());
                }
            }


        }
    }




    public void gameOverMenu(Canvas canvas) {

        v.vibrate(500);
        Paint paint = new Paint();
        //End Screen
        canvas.save();
        paint.setColor(Color.WHITE);
        canvas.drawRect(bt_restart.getCords().left, bt_restart.getCords().top, bt_restart.getCords().right, bt_restart.getCords().bottom, paint);
        paints.writeTextCenter("RESTART", bt_restart.getCords().centerX(), bt_restart.getCords().centerY(), canvas, Color.BLACK, 30);


        if(score > getDataInt()){
            saveDataInt(score);
        }

        canvas.restore();

    }

    public void restart(){
        //start new
        invalidate();

    }

    public void exit(){
        ((Activity) getContext()).finish();
    }

    public int getDataInt() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("HighScore", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("", 0);
    }

    public void saveDataInt(int data) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("HighScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("", data);
        editor.commit();
    }


}
