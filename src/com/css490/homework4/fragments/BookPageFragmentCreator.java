
package com.css490.homework4.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.css490.homework4.ToolbarCallbacks;

/**
 * A factory class to instantiate different fragments that are part of the class
 * 
 * @author Tim Mikeladze
 */
public class BookPageFragmentCreator {
	
	/**
	 * Instantiate a fragment
	 * 
	 * @param context the context
	 * @param c the class of the fragment
	 * @param image the image of the page
	 * @return the fragment
	 */
	public static Fragment instantiate(Context context, Class<?> c, int image) {
		return instantiate(context, c, image, 0, null);
	}
	
	/**
	 * Instantiate a fragment with toolbar callbacks
	 * 
	 * @param context the context
	 * @param c the class of the fragment
	 * @param image the image of the page
	 * @param toolbarCallbacks the toolbar callbacks
	 * @return the fragment
	 */
	public static Fragment instantiate(Context context, Class<?> c, int image, ToolbarCallbacks toolbarCallbacks) {
		return instantiate(context, c, image, 0, toolbarCallbacks);
		
	}
	
	/**
	 * Instantiate a fragment with toolbar callbacks and a certain layout
	 * 
	 * @param context the context
	 * @param c the class of the fragment
	 * @param image the image of the page
	 * @param layout the layout to be used
	 * @param toolbarCallbacks the toolbar callbacks
	 * @return the fragment
	 */
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
