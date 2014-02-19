
package com.css490.homework4.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.css490.homework4.fragments.DrawingCallbacks;
import com.css490.homework4.view.DrawingStrokes;

public class ChooseStrokeDialog implements DialogInterface.OnClickListener {

    private static final String TITLE = "Choose a stroke width...";
    private AlertDialog dialog;
    private DrawingCallbacks drawingCallbacks;

    public ChooseStrokeDialog(final Context context, final DrawingCallbacks drawingCallbacks) {
        this.drawingCallbacks = drawingCallbacks;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setItems(new CharSequence[] { "Tiny", "Small", "Medium", "Large", "Extra Large" },
                new DialogInterface.OnClickListener() {

                    @Override
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
                    }
                });
        dialog = builder.create();

        dialog.setTitle(TITLE);
        dialog.setCancelable(true);
    }

    public void show() {
        dialog.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
