
package com.css490.homework4.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AboutDialog {
	
	private static final String TITLE = "Clifford the Big Red Dog coloring book";
	private static final String BUTTON_NEUTRAL_TEXT = "Return to reading";
	private static final String ABOUT_TEXT = "Clifford teaches important life lessons in this book, such as how to be responsible, how to be truthful, and how to believe in yourself.";
	private AlertDialog alertDialog;
	
	public AboutDialog(Context context) {
		alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle(TITLE);
		alertDialog.setCancelable(true);
		alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, BUTTON_NEUTRAL_TEXT, (DialogInterface.OnClickListener) null);
	}
	
	public void show() {
		alertDialog.setMessage(ABOUT_TEXT);
		alertDialog.show();
	}
}