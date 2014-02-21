
package com.css490.homework4;

import java.util.Random;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.css490.homework4.fragments.BookPageFragmentCreator;
import com.css490.homework4.fragments.PageFragment;
import com.css490.homework4.fragments.TitlePageFragment;
import com.css490.homework4.view.BookViewPager;

/**
 * The main activity, this contains the book
 * 
 * @author Tim Mikeladze
 */
public class MainActivity extends FragmentActivity implements OnPageChangeListener, ToolbarCallbacks {
	
	private static final int[] SOUNDS = { R.raw.sound1, R.raw.sound2, R.raw.sound3, R.raw.sound4, R.raw.sound5 };
	
	private BookViewPager viewPager;
	private PageFragmentAdapter pageFragmentAdapter;
	private Random random;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		
		random = new Random();
		
		viewPager = (BookViewPager) findViewById(R.id.view_pager);
		viewPager.setOnPageChangeListener(this);
		viewPager.setOffscreenPageLimit(0);
		
		pageFragmentAdapter = new PageFragmentAdapter(this, getSupportFragmentManager());
		
		addPages();
	}
	
	/**
	 * Adds the page fragments to the adapter and view pager.
	 */
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
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page15, R.layout.fragment_page_15,
				this));
		pageFragmentAdapter.addFragment(BookPageFragmentCreator.instantiate(this, PageFragment.class, R.drawable.page16, R.layout.fragment_page_16,
				this));
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
	/**
	 * This method is used to play random sounds on page turns and display toasts on certain pages
	 */
	public void onPageSelected(int position) {
		MediaPlayer.create(this, SOUNDS[random.nextInt(SOUNDS.length)])
					.start();
		position = position + 1;
		switch (position) {
			case 2:
				Toast.makeText(this, "Use the \"Draw\" button to circle \"Big Ideas\" that you have done today", Toast.LENGTH_LONG)
						.show();
				break;
			case 5:
				Toast.makeText(this, "Use the \"Draw\" button to circle all the letters hidden in this picture", Toast.LENGTH_LONG)
						.show();
				break;
			case 7:
				Toast.makeText(this, "Help Clifford clean the ice cream by erasing it using the \"Draw\" and \"Color\" buttons", Toast.LENGTH_LONG)
						.show();
				break;
			case 9:
				Toast.makeText(this, "Use the \"Draw\" button to circle the bone, collar, dog dish and leash hidden in the picture",
						Toast.LENGTH_LONG)
						.show();
				break;
			case 17:
				Toast.makeText(this, "Use the \"Draw\" to draw a path to guide Clifford out of the maze", Toast.LENGTH_LONG)
						.show();
				break;
		
		}
	}
	
	@Override
	/**
	 * Toggles whether the view pager can be swiped through or not
	 */
	public void toggleScroll(boolean scroll) {
		viewPager.toggleScroll(scroll);
	}
	
}
