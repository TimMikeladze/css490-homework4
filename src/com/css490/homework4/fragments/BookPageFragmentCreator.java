
package com.css490.homework4.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BookPageFragmentCreator {

	public static Fragment instantiate(Context context, Class<?> c, int image) {
		Bundle bundle = new Bundle();
		bundle.putInt("imageID", image);
		Fragment fragment = null;

		if (c == TitlePageFragment.class) {
			fragment = TitlePageFragment.instantiate(context, c.getName());
		} else if (c == PageFragment.class) {
			fragment = PageFragment.instantiate(context, c.getName());
		}
		fragment.setArguments(bundle);

		return fragment;
	}
}
