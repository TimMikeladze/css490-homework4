
package com.css490.homework4.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.css490.homework4.util.BitmapLoader;

/**
 * A custom view to provide a drawing surface for the user to draw on.
 * 
 * @author Tim Mikeladze
 */
public class DrawingView extends View {
	
	private static final int HEIGHT_OFFSET = 150;
	private Path drawPath;
	private Paint drawPaint;
	private Paint canvasPaint;
	private Canvas drawCanvas;
	private Bitmap canvasBitmap;
	private Context context;
	private DisplayMetrics metrics;
	private int imageID;
	private boolean hasImage;
	private boolean drawingEnabled;
	private int paintColor = DrawingColors.RED.getColor();
	private float stroke = DrawingStrokes.MEDIUM.getStroke();
	
	/**
	 * Instantiates a new drawing view.
	 * 
	 * @param context the context
	 * @param attrs the attrs
	 */
	public DrawingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		
		setDimensions();
		setupDrawing();
	}
	
	/**
	 * Sets the dimensions object, used for optimized bitmap loading.
	 */
	private void setDimensions() {
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		metrics = new DisplayMetrics();
		display.getMetrics(metrics);
	}
	
	/**
	 * Intialize necessary objects for the drawing view.
	 */
	private void setupDrawing() {
		
		drawPath = new Path();
		drawPaint = new Paint();
		drawPaint.setColor(paintColor);
		drawPaint.setAntiAlias(true);
		drawPaint.setStrokeWidth(stroke);
		drawPaint.setStyle(Paint.Style.STROKE);
		drawPaint.setStrokeJoin(Paint.Join.ROUND);
		drawPaint.setStrokeCap(Paint.Cap.ROUND);
		canvasPaint = new Paint(Paint.DITHER_FLAG);
		
	}
	
	@Override
	/**
	 * Called initially and when the size of the screen changes, instantiates new bitmaps and canvas
	 */
	protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
		super.onSizeChanged(width, height - HEIGHT_OFFSET, oldWidth, oldHeight);
		
		if (hasImage) {
			canvasBitmap = BitmapLoader.loadBitmap(getResources(), imageID, metrics.widthPixels, metrics.heightPixels - HEIGHT_OFFSET)
										.copy(Bitmap.Config.ARGB_8888, true);
		} else {
			canvasBitmap = Bitmap.createBitmap(width, height - HEIGHT_OFFSET, Bitmap.Config.ARGB_8888);
			
		}
		
		drawCanvas = new Canvas(canvasBitmap);
	}
	
	@Override
	/**
	 * Draws the user input
	 */
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
		canvas.drawPath(drawPath, drawPaint);
	}
	
	@Override
	/**
	 * Handles user drawing
	 */
	public boolean onTouchEvent(MotionEvent event) {
		if (drawingEnabled) {
			
			float touchX = event.getX();
			float touchY = event.getY();
			
			switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					drawPath.moveTo(touchX, touchY);
					break;
				case MotionEvent.ACTION_MOVE:
					drawPath.lineTo(touchX, touchY);
					break;
				case MotionEvent.ACTION_UP:
					drawPath.lineTo(touchX, touchY);
					drawCanvas.drawPath(drawPath, drawPaint);
					drawPath.reset();
					break;
				default:
					return false;
			}
			
			invalidate();
		}
		return true;
		
	}
	
	/**
	 * Sets the stroke.
	 * 
	 * @param stroke the new stroke
	 */
	public void setStroke(float stroke) {
		this.stroke = stroke;
		drawPaint.setStrokeWidth(stroke);
	}
	
	/**
	 * Sets the color.
	 * 
	 * @param color the new color
	 */
	public void setColor(int color) {
		invalidate();
		paintColor = color;
		drawPaint.setColor(paintColor);
	}
	
	/**
	 * Sets the image.
	 * 
	 * @param imageID the new image
	 */
	public void setImage(int imageID) {
		this.imageID = imageID;
		hasImage = true;
		invalidate();
	}
	
	/**
	 * Enable drawing.
	 * 
	 * @param drawingEnabled the drawing enabled
	 */
	public void enableDrawing(boolean drawingEnabled) {
		this.drawingEnabled = drawingEnabled;
	}
	
	/**
	 * Enables the eraser
	 * 
	 * @param eraser enable the eraser
	 */
	public void setEraser(boolean eraser) {
		if (eraser) {
			drawPaint.setColor(Color.WHITE);
		} else {
			drawPaint.setColor(paintColor);
		}
	}
	
}