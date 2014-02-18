
package com.css490.homework4.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.css490.homework4.R;
import com.css490.homework4.view.DrawingView;

public class PageFragment extends Fragment {
	
	private int imageID;
	private DrawingView drawingView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_page_generic, container, false);
		
		Bundle bundle = getArguments();
		if (bundle != null) {
			imageID = bundle.getInt("imageID");
			drawingView = (DrawingView) v.findViewById(R.id.view_drawing);
			drawingView.setImage(imageID);
		}
		
		return v;
	}
	
}