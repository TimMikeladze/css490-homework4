
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

		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.view_pager);

		pageFragmentAdapter = new PageFragmentAdapter(getSupportFragmentManager());

		addPages();
	}

	private void addPages() {
		pageFragmentAdapter.addFragment(PageFragmentOne.instantiate(this, PageFragmentOne.class.getName()));
		pageFragmentAdapter.addFragment(PageFragmentOne.instantiate(this, PageFragmentTwo.class.getName()));
		viewPager.setAdapter(pageFragmentAdapter);
	}
}
