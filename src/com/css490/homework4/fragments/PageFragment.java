
package com.css490.homework4.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.css490.homework4.R;
import com.css490.homework4.ToolbarCallbacks;
import com.css490.homework4.dialogs.ChooseColorDialog;
import com.css490.homework4.dialogs.ChooseStrokeDialog;
import com.css490.homework4.view.DrawingView;

/**
 * The PageFragment, used to display a page in a book, allows the users to draw on pages.
 * 
 * @author Tim Mikeladze
 * 
 */
public class PageFragment extends Fragment implements OnClickListener, DrawingCallbacks {
	
	private static final String DRAWING_OFF = "Drawing off";
	private static final String DRAWING_ON = "Drawing on";
	private int imageID;
	private DrawingView drawingView;
	private Button drawButton;
	private Button strokeButton;
	private Button colorButton;
	private ChooseColorDialog chooseColorDialog;
	private ChooseStrokeDialog chooseStrokeDialog;
	
	private boolean drawingEnabled;
	private ToolbarCallbacks toolbarCallbacks;
	
	private ImageView animation;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Bundle bundle = getArguments();
		
		int layoutID = bundle != null && bundle.containsKey("layoutID") ? bundle.getInt("layoutID") : R.layout.fragment_page_generic;
		View v = inflater.inflate(layoutID, container, false);
		
		drawButton = (Button) v.findViewById(R.id.button_draw);
		drawButton.setOnClickListener(this);
		strokeButton = (Button) v.findViewById(R.id.button_stroke);
		strokeButton.setOnClickListener(this);
		colorButton = (Button) v.findViewById(R.id.button_color);
		colorButton.setOnClickListener(this);
		
		chooseColorDialog = new ChooseColorDialog(getActivity(), this);
		chooseStrokeDialog = new ChooseStrokeDialog(getActivity(), this);
		
		if (bundle != null) {
			imageID = bundle.getInt("imageID");
			drawingView = (DrawingView) v.findViewById(R.id.view_drawing);
			drawingView.setImage(imageID);
			
		}
		
		animation = (ImageView) v.findViewById(R.id.animation);
		if (animation != null) {
			try {
				AnimationDrawable frameAnimation = (AnimationDrawable) animation.getBackground();
				frameAnimation.start();
			} catch (Exception e) {
				
			}
		}
		
		return v;
	}
	
	/**
	 * Adds toolbar callbacks, used to lock the swiping of the view pager
	 * 
	 * @param toolbarCallbacks the callbacks
	 */
	public void addToolbarCallbacks(ToolbarCallbacks toolbarCallbacks) {
		this.toolbarCallbacks = toolbarCallbacks;
	}
	
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		if (v.getId() == drawButton.getId()) {
			toggleDrawing();
		} else if (v.getId() == strokeButton.getId()) {
			selectStroke();
		} else if (v.getId() == colorButton.getId()) {
			selectColor();
		}
	}
	
	/**
	 * Toggle drawing, hides or shows the drawing buttons and enables or disables drawing
	 * functionality.
	 */
	private void toggleDrawing() {
		drawingEnabled = !drawingEnabled;
		drawingView.enableDrawing(drawingEnabled);
		if (toolbarCallbacks != null) {
			toolbarCallbacks.toggleScroll(drawingEnabled);
		}
		if (drawingEnabled) {
			strokeButton.setVisibility(View.VISIBLE);
			colorButton.setVisibility(View.VISIBLE);
			if (animation != null) {
				animation.setVisibility(View.INVISIBLE);
			}
		} else {
			strokeButton.setVisibility(View.INVISIBLE);
			colorButton.setVisibility(View.INVISIBLE);
			if (animation != null) {
				animation.setVisibility(View.VISIBLE);
			}
		}
		drawButton.setText(drawingEnabled ? DRAWING_ON : DRAWING_OFF);
		
	}
	
	/**
	 * Select stroke width.
	 */
	private void selectStroke() {
		chooseStrokeDialog.show();
	}
	
	/**
	 * Select color.
	 */
	private void selectColor() {
		chooseColorDialog.show();
	}
	
	@Override
	/**
	 * Set the color in the drawing view
	 */
	public void setColor(int color) {
		drawingView.setColor(color);
		setEraser(false);
	}
	
	@Override
	/**
	 * Set the stroke in the drawing view
	 */
	public void setStroke(float stroke) {
		drawingView.setStroke(stroke);
		
	}
	
	@Override
	/**
	 * Set eraser as enabled or disabled in the drawing view
	 */
	public void setEraser(boolean eraser) {
		drawingView.setEraser(eraser);
	}
	
}