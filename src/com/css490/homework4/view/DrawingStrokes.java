
package com.css490.homework4.view;

/**
 * The Enum DrawingStrokes, contains different stroke widths for the drawing view.
 * 
 * @author Tim Mikeladze
 */
public enum DrawingStrokes {
	
	TINY(2.5f), SMALL(7.5f), MEDIUM(15), LARGE(20), EXTRALARGE(35);
	
	private float stroke;
	
	/**
	 * Instantiates a new drawing strokes.
	 * 
	 * @param stroke the stroke
	 */
	private DrawingStrokes(float stroke) {
		this.stroke = stroke;
	}
	
	/**
	 * Gets the stroke
	 * 
	 * @return the stroke
	 */
	public float getStroke() {
		return stroke;
	}
}
