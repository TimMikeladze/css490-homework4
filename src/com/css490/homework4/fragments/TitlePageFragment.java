
package com.css490.homework4.fragments;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.css490.homework4.R;
import com.css490.homework4.dialogs.AboutDialog;
import com.css490.homework4.util.BitmapLoader;

public class TitlePageFragment extends Fragment implements OnClickListener {
	
	private AboutDialog aboutDialog;
	private Button aboutButton;
	private int imageID;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_page_title, container, false);
		
		aboutDialog = new AboutDialog(getActivity());
		aboutButton = (Button) v.findViewById(R.id.button_about);
		aboutButton.setOnClickListener(this);
		
		Bundle bundle = getArguments();
		if (bundle != null) {
			imageID = bundle.getInt("imageID");
			Display display = ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
			DisplayMetrics metrics = new DisplayMetrics();
			display.getMetrics(metrics);
			
			v.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapLoader.loadBitmap(getResources(), imageID, metrics.widthPixels,
					metrics.heightPixels)));
		}
		
		return v;
	}
	
	@Override
	public void onClick(View v) {
		if (v.getId() == aboutButton.getId()) {
			aboutDialog.show();
		}
	}
	
}