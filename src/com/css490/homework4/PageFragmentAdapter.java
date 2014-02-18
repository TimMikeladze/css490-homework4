
package com.css490.homework4;

import java.util.LinkedList;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageFragmentAdapter extends FragmentPagerAdapter {
	
	private Context context;
	private LinkedList<Fragment> fragments;
	
	public PageFragmentAdapter(Context context, FragmentManager fragmentManager) {
		super(fragmentManager);
		this.context = context;
		fragments = new LinkedList<Fragment>();
	}
	
	public void addFragment(Fragment f) {
		fragments.add(f);
	}
	
	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}
	
	@Override
	public int getCount() {
		return fragments.size();
	}
	
}
