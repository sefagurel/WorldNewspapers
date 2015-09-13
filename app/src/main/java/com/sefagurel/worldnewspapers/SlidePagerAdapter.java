package com.sefagurel.worldnewspapers;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sefagurel on 13.09.2015.
 */
public class SlidePagerAdapter extends FragmentPagerAdapter {

	List<Fragment>	fragmentList;
	Bundle			bundle;
	int				fragmentId;

	public SlidePagerAdapter(FragmentManager fm) {
		super(fm);

		fragmentList = new ArrayList<>();
		fragmentList.add(new Fragment1());
		fragmentList.add(new Fragment2());
		fragmentList.add(new Fragment3());

	}

	public void addBundle(int fragmentId, Bundle bundle) {
		this.bundle = bundle;
		this.fragmentId = fragmentId;
	}

	@Override
	public Fragment getItem(int position) {

		Fragment fragment = fragmentList.get(position);
		if (bundle != null && position == fragmentId) {
			fragment.setArguments(bundle);
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}

}
