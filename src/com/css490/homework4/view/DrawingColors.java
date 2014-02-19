package com.css490.homework4.view;


public enum DrawingColors {
    RED(0x98db1c2b), GREEN(0x98008000), BLUE(0x980000FF), YELLOW(0x98FFFF00), ORANGE(0x98FFA500), BROWN(0x988B4513), PINK(0x98FF69B4), PURPLE(0x98800080);

    private int color;

    private DrawingColors(int color ){
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
