
package com.css490.homework4;

import java.util.LinkedList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageFragmentAdapter extends FragmentPagerAdapter {
	
	private LinkedList<Fragment> fragments;
	
	public PageFragmentAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
		fragments = new LinkedList<Fragment>();
		
	}
	
	public void addFragment(Fragment f) {
		fragments.add(f);
	}
	
	@Override
	public Fragment getItem(int position) {
		return this.fragments.get(position);
	}
	
	@Override
	public int getCount() {
		return this.fragments.size();
	}
	
}
