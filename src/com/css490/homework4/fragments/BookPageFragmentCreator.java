
package com.css490.homework4.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.css490.homework4.ToolbarCallbacks;

public class BookPageFragmentCreator {

    public static Fragment instantiate(Context context, Class<?> c, int image) {
        return instantiate(context, c, image, null);
    }

	public static Fragment instantiate(Context context, Class<?> c, int image, ToolbarCallbacks toolbarCallbacks) {
		Bundle bundle = new Bundle();
		bundle.putInt("imageID", image);
		Fragment fragment = null;

		if (c == TitlePageFragment.class) {
			fragment = TitlePageFragment.instantiate(context, c.getName());
		} else if (c == PageFragment.class) {
			fragment = PageFragment.instantiate(context, c.getName());
			if(toolbarCallbacks != null) {
			    ((PageFragment) fragment).addToolbarCallbacks(toolbarCallbacks);
			}
		}
		fragment.setArguments(bundle);

		return fragment;
	}
}
