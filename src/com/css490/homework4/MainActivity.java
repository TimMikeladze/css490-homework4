
package com.css490.homework4;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;
import android.view.WindowManager;

import com.css490.homework4.fragments.BookPageFragmentCreator;
import com.css490.homework4.fragments.PageFragment;
import com.css490.homework4.fragments.TitlePageFragment;
import com.css490.homework4.view.BookViewPager;

public class MainActivity extends FragmentActivity implements OnPageChangeListener, ToolbarCallbacks {
	
	private BookViewPager viewPager;
	private PageFragmentAdapter pageFragmentAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		
		viewPager = (BookViewPager) findViewById(R.id.view_pager);
		viewPager.setOnPageChangeListener(this);
		onPageSelected(0);
		
		pageFragmentAdapter = new PageFragmentAdapter(this, getSupportFragmentManager());
		
		addPages();
	}
	
	private void addPages() {
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, TitlePageFragment.class, R.drawable.page1));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page2, R.layout.fragment_page_2,
				this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page3, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page4, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page5, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page6, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page7, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page8, R.layout.fragment_page_8,
				this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page9, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page10, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page11, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page12, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page13, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page14, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page15, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page16, this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page17, R.layout.fragment_page_17,
				this));
		
		viewPager.setAdapter(pageFragmentAdapter);
		
	}
	
	@Override
	public void onPageScrollStateChanged(int state) {
	}
	
	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		
	}
	
	@Override
	public void onPageSelected(int position) {
		
	}
	
	@Override
	public void toggleScroll(boolean scroll) {
		viewPager.toggleScroll(scroll);
	}
	
}
