
package com.css490.homework4.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import com.css490.homework4.fragments.DrawingCallbacks;
import com.css490.homework4.view.DrawingColors;

public class ChooseColorDialog implements OnClickListener {
	
	private static final String TITLE = "Choose a paint color...";
	private AlertDialog dialog;
	private DrawingCallbacks drawingCallbacks;
	
	public ChooseColorDialog(Context context, DrawingCallbacks drawingCallbacks) {
		this.drawingCallbacks = drawingCallbacks;
		
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		
		builder.setSingleChoiceItems(new CharSequence[] { "Red", "Green", "Blue", "Yellow", "Orange", "Brown", "Purple", "Pink", "Eraser" }, 0, this);
		
		dialog = builder.create();
		
		dialog.setTitle(TITLE);
		dialog.setCancelable(true);
	}
	
	public void show() {
		dialog.show();
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
			case 0:
				drawingCallbacks.setColor(DrawingColors.RED.getColor());
				break;
			case 1:
				drawingCallbacks.setColor(DrawingColors.GREEN.getColor());
				break;
			case 2:
				drawingCallbacks.setColor(DrawingColors.BLUE.getColor());
				break;
			case 3:
				drawingCallbacks.setColor(DrawingColors.YELLOW.getColor());
				break;
			case 4:
				drawingCallbacks.setColor(DrawingColors.ORANGE.getColor());
				break;
			case 5:
				drawingCallbacks.setColor(DrawingColors.BROWN.getColor());
				break;
			case 6:
				drawingCallbacks.setColor(DrawingColors.PURPLE.getColor());
				break;
			case 7:
				drawingCallbacks.setColor(DrawingColors.PINK.getColor());
				break;
			case 8:
				drawingCallbacks.setEraser(true);
				break;
		}
		dialog.dismiss();
	}
}
