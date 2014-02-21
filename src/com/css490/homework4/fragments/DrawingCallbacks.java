
package com.css490.homework4.fragments;

/**
 * The Interface DrawingCallbacks. Used to communicate between page fragments and the drawing
 * view
 * 
 * @author Tim Mikeladze
 */
public interface DrawingCallbacks {
	
	/**
	 * Sets the color.
	 * 
	 * @param color the new color
	 */
	public void setColor(int color);
	
	/**
	 * Sets the stroke.
	 * 
	 * @param stroke the new stroke
	 */
	public void setStroke(float stroke);
	
	/**
	 * Sets the eraser.
	 * 
	 * @param eraser the new eraser
	 */
	public void setEraser(boolean eraser);
}
