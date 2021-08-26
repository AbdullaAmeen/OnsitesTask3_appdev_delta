package com.example.diffuse.Objects;

import android.graphics.RectF;

public class Box {
    private RectF cords;

    public Box(float height, float width, float x, float y ) {
        cords = new RectF(x,y,x + width,y + height);
    }

    public RectF getCords() {
        return cords;
    }

    public void setCords(RectF cords) {
        this.cords = cords;
    }
}