
package com.css490.homework4;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	private ViewPager viewPager;
	private PageFragmentAdapter pageFragmentAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.view_pager);

		pageFragmentAdapter = new PageFragmentAdapter(getSupportFragmentManager());

		addPages();
	}

	private void addPages() {
		pageFragmentAdapter.addFragment(PageFragment.instantiate(this, PageFragment.class.getName()));
		viewPager.setAdapter(pageFragmentAdapter);
	}
}
