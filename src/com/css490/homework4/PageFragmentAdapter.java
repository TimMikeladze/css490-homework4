
package com.css490.homework4;

import java.util.LinkedList;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * The Class PageFragmentAdapter, used to manage fragments for a view pager.
 * 
 * @author Tim Mikeladze
 */
public class PageFragmentAdapter extends FragmentPagerAdapter {
	
	private LinkedList<Fragment> fragments;
	
	/**
	 * Instantiates a new page fragment adapter.
	 * 
	 * @param context the context
	 * @param fragmentManager the fragment manager
	 */
	public PageFragmentAdapter(Context context, FragmentManager fragmentManager) {
		super(fragmentManager);
		fragments = new LinkedList<Fragment>();
	}
	
	/**
	 * Adds the fragment to the adapter
	 * 
	 * @param f the fragment to add
	 */
	public void addFragment(Fragment f) {
		fragments.add(f);
	}
	
	@Override
	/**
	 * Get the current fragment
	 */
	public Fragment getItem(int position) {
		return fragments.get(position);
	}
	
	@Override
	/**
	 * Get the number of fragments in the adapter
	 */
	public int getCount() {
		return fragments.size();
	}
	
}
