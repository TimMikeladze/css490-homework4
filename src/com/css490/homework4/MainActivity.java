
package com.css490.homework4;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;
import android.view.WindowManager;

import com.css490.homework4.fragments.BookPageFragmentCreator;
import com.css490.homework4.fragments.PageFragment;
import com.css490.homework4.fragments.TitlePageFragment;

public class MainActivity extends FragmentActivity implements OnPageChangeListener {

	private ViewPager viewPager;
	private PageFragmentAdapter pageFragmentAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id.view_pager);
		viewPager.setOnPageChangeListener(this);
		onPageSelected(0);

		pageFragmentAdapter = new PageFragmentAdapter(this, getSupportFragmentManager());

		addPages();
	}

	private void addPages() {
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, TitlePageFragment.class, R.drawable.page1));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page2));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page3));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page4));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page5));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page6));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page7));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page8));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page9));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page10));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page11));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page12));

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


}
