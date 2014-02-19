package com.css490.homework4.view;


public enum DrawingColors {
    RED(0x99db1c2b), GREEN(0x99008000), BLUE(0x990000FF), YELLOW(0x99FFFF00), ORANGE(0x99FFA500), BROWN(0x998B4513), PINK(0x99FF69B4), PURPLE(0x99800080);

    private int color;

    private DrawingColors(int color ){
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
