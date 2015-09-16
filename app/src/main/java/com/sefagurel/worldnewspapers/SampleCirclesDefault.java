package com.sefagurel.worldnewspapers;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.sefagurel.worldnewspapers.viewpagerindicator.LinePageIndicator;
import com.sefagurel.worldnewspapers.viewpagerindicator.PageIndicator;
import com.sefagurel.worldnewspapers.viewpagerindicator.UnderlinePageIndicator;

public class SampleCirclesDefault extends FragmentActivity implements Communicator {

	ViewPager			mPager;
	SlidePagerAdapter	mPagerAdapter;
	PageIndicator		mIndicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_circles);

		mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mPagerAdapter);

		mIndicator = (LinePageIndicator) findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
	}

	@Override
	public void setCurrentPage(int page, Bundle bundle) {
		mPagerAdapter.addBundle(page, bundle);
		mPager.setCurrentItem(page, true);
	}
}