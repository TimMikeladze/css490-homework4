
package com.css490.homework4.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.css490.homework4.ToolbarCallbacks;

public class BookPageFragmentCreator {
	
	public static Fragment instantiate(Context context, Class<?> c, int image) {
		return instantiate(context, c, image, 0, null);
	}
	
	public static Fragment instantiate(Context context, Class<?> c, int image, ToolbarCallbacks toolbarCallbacks) {
		return instantiate(context, c, image, 0, toolbarCallbacks);
		
	}
	
	public static Fragment instantiate(Context context, Class<?> c, int image, int layout, ToolbarCallbacks toolbarCallbacks) {
		Bundle bundle = new Bundle();
		bundle.putInt("imageID", image);
		if (layout != 0) {
			bundle.putInt("layoutID", layout);
		}
		
		Fragment fragment = null;
		
		if (c == TitlePageFragment.class) {
			fragment = TitlePageFragment.instantiate(context, c.getName());
		} else if (c == PageFragment.class) {
			fragment = PageFragment.instantiate(context, c.getName());
			if (toolbarCallbacks != null) {
				((PageFragment) fragment).addToolbarCallbacks(toolbarCallbacks);
			}
		}
		fragment.setArguments(bundle);
		
		return fragment;
	}
}
