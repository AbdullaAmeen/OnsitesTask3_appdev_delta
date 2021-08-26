package com.example.diffuse.Objects;

public class Wire {
    public static int WIRE_WIDTH = 30,HOLDER_WIDTH = 35;



    private Box box;
    private int Color;

    public Wire(Box cords, int color) {
        this.box = cords;
        Color = color;
    }
    public Box getBox() {
        return box;
    }

    public void setBox(Box cords) {
        this.box = cords;
    }

    public int getColor() {
        return Color;
    }
}
