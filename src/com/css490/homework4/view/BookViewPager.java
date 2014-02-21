
package com.css490.homework4.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * A custom ViewPager with locking functionality to disable swiping.
 * 
 * @author Tim Mikeladze
 */
public class BookViewPager extends ViewPager {
	
	private Context context;
	private boolean isLocked;
	
	/**
	 * Instantiates a new book view pager.
	 * 
	 * @param context the context
	 */
	public BookViewPager(Context context) {
		super(context);
		this.context = context;
	}
	
	/**
	 * Instantiates a new book view pager.
	 * 
	 * @param context the context
	 * @param attrs the attrs
	 */
	public BookViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (!isLocked) {
			return super.onTouchEvent(event);
		}
		return false;
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		if (!isLocked) {
			return super.onInterceptTouchEvent(event);
		}
		return false;
	}
	
	/**
	 * Toggle scrolling.
	 * 
	 * @param isLocked scrolling is locked
	 */
	public void toggleScroll(boolean isLocked) {
		this.isLocked = isLocked;
	}
}
