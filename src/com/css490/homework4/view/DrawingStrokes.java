
package com.css490.homework4.view;

public enum DrawingStrokes {
	
	TINY(2.5f), SMALL(7.5f), MEDIUM(15), LARGE(20), EXTRALARGE(35);
	
	private float stroke;
	
	private DrawingStrokes(float stroke) {
		this.stroke = stroke;
	}
	
	public float getStroke() {
		return stroke;
	}
}
