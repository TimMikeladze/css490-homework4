
package com.css490.homework4.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import com.css490.homework4.fragments.DrawingCallbacks;
import com.css490.homework4.view.DrawingStrokes;

/**
 * A dialog to select the stroke.
 * 
 * @author Tim Mikeladze
 */
public class ChooseStrokeDialog implements OnClickListener {
	
	private static final String TITLE = "Choose a stroke width...";
	private AlertDialog dialog;
	private DrawingCallbacks drawingCallbacks;
	
	/**
	 * Instantiates a new choose stroke dialog.
	 * 
	 * @param context the context
	 * @param drawingCallbacks the drawing callbacks
	 */
	public ChooseStrokeDialog(final Context context, final DrawingCallbacks drawingCallbacks) {
		this.drawingCallbacks = drawingCallbacks;
		
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		
		builder.setSingleChoiceItems(new CharSequence[] { "Tiny", "Small", "Medium", "Large", "Extra Large" }, 2, this);
		
		dialog = builder.create();
		
		dialog.setTitle(TITLE);
		dialog.setCancelable(true);
	}
	
	/**
	 * Show the dialog
	 */
	public void show() {
		dialog.show();
	}
	
	@Override
	/**
	 * Select a stroke
	 */
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
			case 0:
				drawingCallbacks.setStroke(DrawingStrokes.TINY.getStroke());
				break;
			case 1:
				drawingCallbacks.setStroke(DrawingStrokes.SMALL.getStroke());
				break;
			case 2:
				drawingCallbacks.setStroke(DrawingStrokes.MEDIUM.getStroke());
				break;
			case 3:
				drawingCallbacks.setStroke(DrawingStrokes.LARGE.getStroke());
				break;
			case 4:
				drawingCallbacks.setStroke(DrawingStrokes.EXTRALARGE.getStroke());
				break;
		}
		dialog.dismiss();
	}
}
