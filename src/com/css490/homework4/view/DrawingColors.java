
package com.css490.homework4.view;

/**
 * The Enum DrawingColors, contains different colors used by the drawing view.
 * 
 * @author Tim Mikeladze
 */
public enum DrawingColors {
	RED(0xCCdb1c2b), GREEN(0xCC008000), BLUE(0xCC0000FF), YELLOW(0xCCFFFF00), ORANGE(0xCCFFA500), BROWN(0xCC8B4513), PINK(0xCCFF69B4), PURPLE(
			0xCC800080);
	
	private int color;
	
	/**
	 * Instantiates a new drawing colors.
	 * 
	 * @param color the color
	 */
	private DrawingColors(int color) {
		this.color = color;
	}
	
	/**
	 * Gets the color.
	 * 
	 * @return the color
	 */
	public int getColor() {
		return color;
	}
}
