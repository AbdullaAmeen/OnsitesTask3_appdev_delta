package com.example.diffuse.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Paints {
    public static final int colorWireRed=Color.parseColor("#800000"),colorWireBlue=Color.parseColor("#506680"), colorWireGreen=Color.parseColor("#237563"), colorButton=Color.parseColor("#F9fbff");
    public static final int colorBackGround=Color.parseColor("#000000"),colorInnerBox=Color.parseColor("#3a3b3c"), colorHolder=Color.parseColor("#AAAAAA") ;
    Paint paintWire;
    Paint paintHolder;

    public Paint getPaintMinScreen() {
        return paintMinScreen;
    }

    Paint paintMinScreen;

    public Paint getPaintButton() {
        return paintButton;
    }

    Paint paintButton;

    public Paints() {
        paintWire = new Paint();


        paintButton = new Paint();
        paintButton.setColor(colorButton);

        paintHolder = new Paint();
        paintHolder.setColor(colorHolder);

        paintMinScreen = new Paint();
        paintMinScreen.setColor(colorInnerBox);


    }



    public void writeTextCenter(String text, float x, float y, Canvas canvas, int color, float fontSize) {
        android.graphics.Paint paintText = new android.graphics.Paint();
        paintText.setColor(color);
        paintText.setStyle(android.graphics.Paint.Style.FILL);
        paintText.setAntiAlias(true);
        //Typeface Arcade = ResourcesCompat.getFont(getContext(), R.font.arcaden);
        //paintText.setTypeface(Arcade);
        paintText.setTextSize(fontSize);
        float xPos = x;
        paintText.setTextAlign(android.graphics.Paint.Align.CENTER);
        float yPos =  (y - (paintText.descent() + paintText.ascent()) / 2);
        canvas.save();  //
        canvas.drawText(text, x, yPos, paintText);
        canvas.restore();

    }

   public void wireSetColor(int color) {
        switch(color){
            case WireSet.COLOR_RED:
                paintWire.setColor(colorWireRed);
                break;
            case WireSet.COLOR_GREEN:
                paintWire.setColor(colorWireGreen);
                break;
            case WireSet.COLOR_BLUE:
                paintWire.setColor(colorWireBlue);
                break;
        }
    }

    public Paint getPaintWire() {
        return paintWire;
    }


    public Paint getPaintHolder() {
        return paintHolder;
    }
}
