
package com.css490.homework4.view;

public enum DrawingColors {
	RED(0xCCdb1c2b), GREEN(0xCC008000), BLUE(0xCC0000FF), YELLOW(0xCCFFFF00), ORANGE(0xCCFFA500), BROWN(0xCC8B4513), PINK(0xCCFF69B4), PURPLE(
			0xCC800080);
	
	private int color;
	
	private DrawingColors(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
}
