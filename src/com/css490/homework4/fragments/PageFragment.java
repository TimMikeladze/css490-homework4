
package com.css490.homework4.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.css490.homework4.R;
import com.css490.homework4.ToolbarCallbacks;
import com.css490.homework4.dialogs.ChooseColorDialog;
import com.css490.homework4.dialogs.ChooseStrokeDialog;
import com.css490.homework4.view.DrawingView;

public class PageFragment extends Fragment implements OnClickListener, DrawingCallbacks {

    private int imageID;
    private DrawingView drawingView;
    private Button drawButton;
    private Button strokeButton;
    private Button colorButton;
    private ChooseColorDialog chooseColorDialog;
    private ChooseStrokeDialog chooseStrokeDialog;

    private boolean drawingEnabled;
    private ToolbarCallbacks toolbarCallbacks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page_generic, container, false);

        drawButton = (Button) v.findViewById(R.id.button_draw);
        drawButton.setOnClickListener(this);
        strokeButton = (Button) v.findViewById(R.id.button_stroke);
        strokeButton.setOnClickListener(this);
        colorButton = (Button) v.findViewById(R.id.button_color);
        colorButton.setOnClickListener(this);

        chooseColorDialog = new ChooseColorDialog(getActivity(), this);
        chooseStrokeDialog = new ChooseStrokeDialog(getActivity(), this);


        Bundle bundle = getArguments();
        if (bundle != null) {
            imageID = bundle.getInt("imageID");
            drawingView = (DrawingView) v.findViewById(R.id.view_drawing);
            drawingView.setImage(imageID);
        }
        return v;
    }

    public void addToolbarCallbacks(ToolbarCallbacks toolbarCallbacks) {
        this.toolbarCallbacks = toolbarCallbacks;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == drawButton.getId()) {
            toggleDrawing();
        }
        else if (v.getId() == strokeButton.getId()) {
            selectStroke();
        }
        else if (v.getId() == colorButton.getId()) {
            selectColor();
        }
    }

    private void toggleDrawing() {
        drawingEnabled = !drawingEnabled;
        drawingView.enableDrawing(drawingEnabled);
        if(toolbarCallbacks != null) {
            toolbarCallbacks.toggleScroll(drawingEnabled);
        }
        drawButton.setText(drawingEnabled ? "Draw on" : "Draw off");

    }

    private void selectStroke() {
        chooseStrokeDialog.show();
    }

    private void selectColor() {
        chooseColorDialog.show();
    }

    @Override
    public void setColor(int color) {
        drawingView.setColor(color);
    }

    @Override
    public void setStroke(float stroke) {
        drawingView.setStroke(stroke);

    }

}