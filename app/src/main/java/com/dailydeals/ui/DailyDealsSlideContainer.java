package com.dailydeals.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dailydeals.DailyDeal;
import com.dailydeals.R;
import com.dailydeals.custom.CustomFragment;

// TODO: Auto-generated Javadoc
/**
 * The Class DailyDealsSlideContainer is fragment to perform the 
 * swipe navigation of the slides and tabs.
 */
public class DailyDealsSlideContainer extends CustomFragment{

	/** The Constant NUM_PAGES. */
	private static final int NUM_PAGES = 3;
	
	/** The pager. */
	private ViewPager pager;
	
	/** The adapter slides the page. */
	private SlideAdapter adapter;
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.screen_slide_deals, null);
		pager = (ViewPager)v.findViewById(R.id.pager);
		adapter = new SlideAdapter(getFragmentManager());
		pager.setAdapter(adapter);
		pager.setCurrentItem(DailyDeal.pos, true);
		pager.setPageTransformer(true, new ZoomOutPageTransformer());
		pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
		{

			@Override
			public void onPageSelected(int position) {
				
				((DailyDeal)getActivity()).tabChanger(position+1);
			}
			
		});
		return v;
	}
	
	/**
	 * The Class SlideAdapter.
	 */
	private class SlideAdapter extends FragmentStatePagerAdapter{

		/**
		 * Instantiates a new slide adapter.
		 *
		 * @param fm the fm
		 */
		public SlideAdapter(FragmentManager fm) {
			super(fm);
			
		}

		/* (non-Javadoc)
		 * @see android.support.v4.app.FragmentStatePagerAdapter#getItem(int)
		 */
		@Override
		public Fragment getItem(int position) {
			DailyDealsContainer fragment = new DailyDealsContainer();
			return   fragment;
		}

		/* (non-Javadoc)
		 * @see android.support.v4.view.PagerAdapter#getCount()
		 */
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return NUM_PAGES;
		}
		
	}
	

}
