
package com.css490.homework4;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends FragmentActivity {
	
	private ViewPager viewPager;
	private List<Fragment> fragments;
	private PageFragmentAdapter pageFragmentAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		
		viewPager = (ViewPager) findViewById(R.id.view_pager);
		fragments = new ArrayList<Fragment>();
		
		pageFragmentAdapter = new PageFragmentAdapter(getSupportFragmentManager(), fragments);
		
		viewPager.setAdapter(pageFragmentAdapter);
	}
}
