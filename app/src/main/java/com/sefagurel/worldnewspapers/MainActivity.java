package com.sefagurel.worldnewspapers;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Communicator {

	private Toolbar					mToolbar;
	private DrawerLayout			mDrawerLayout;
	private ActionBarDrawerToggle	mDrawerToggle;

	ViewPager			mPager;
	SlidePagerAdapter	mPagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		// mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
		// mDrawerLayout.setDrawerListener(new DemoDrawerListener());

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				// Snackbar.make(view, "acildi", Snackbar.LENGTH_SHORT).show();
				invalidateOptionsMenu(); // creates call to
				// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				// Snackbar.make(drawerView, "kapandi", Snackbar.LENGTH_SHORT).show();
				invalidateOptionsMenu(); // creates call to
				// onPrepareOptionsMenu()
			}

		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		mDrawerLayout.post(new Runnable() {
			@Override
			public void run() {
				mDrawerToggle.syncState();
			}
		});

		// FragmentManager fragmentManager = getSupportFragmentManager();
		// FragmentTransaction ft = fragmentManager.beginTransaction();
		// Fragment fragment = new Fragment1();
		// ft.replace(R.id.container, fragment);
		// ft.commit();

		mPager = (ViewPager) findViewById(R.id.vpPager);
		mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);

		mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void setCurrentPage(int page, Bundle bundle) {
		mPagerAdapter.addBundle(page, bundle);
		mPager.setCurrentItem(page, true);
	}

	class DemoDrawerListener implements DrawerLayout.DrawerListener {
		@Override
		public void onDrawerOpened(View drawerView) {
			mDrawerToggle.onDrawerOpened(drawerView);
			Snackbar.make(drawerView, "acildi", Snackbar.LENGTH_SHORT).show();
		}

		@Override
		public void onDrawerClosed(View drawerView) {
			mDrawerToggle.onDrawerClosed(drawerView);
			Snackbar.make(drawerView, "kapandi", Snackbar.LENGTH_SHORT).show();
		}

		@Override
		public void onDrawerSlide(View drawerView, float slideOffset) {
			mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
		}

		@Override
		public void onDrawerStateChanged(int newState) {
			mDrawerToggle.onDrawerStateChanged(newState);
		}
	}

}
