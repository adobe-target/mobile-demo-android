package com.dailydeals;

import java.util.ArrayList;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.dailydeals.custom.CustomActivity;
import com.dailydeals.model.Data;
import com.dailydeals.ui.DailyDealsSlideContainer;
import com.dailydeals.ui.LeftNavAdapter;
import com.dailydeals.ui.MyProfile;
import com.dailydeals.ui.MyPurchases;
// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity is the base activity class of the application. This
 * activity is launched after the Login and it holds all the Fragments used in
 * the app. It also creates the Navigation Drawer on left side.
 */
public class DailyDeal extends CustomActivity {

	/** The drawer layout. */
	private DrawerLayout drawerLayout;

	/** ListView for left side drawer. */
	private View drawerLeft;

	/** The drawer toggle. */
	private ActionBarDrawerToggle drawerToggle;

	/** The adapter for left navigation ListView. */
	private LeftNavAdapter adapter;
	
	/** The tabStrip1. */
	private View tabStrip1;
	
	/** The tabStrip2. */
	private View tabStrip2;
	
	/** The tabStrip3. */
	private View tabStrip3;
	
	/** The tab1. */
	private Button tab1;
	
	/** The tab2. */
	private Button tab2;
	
	/** The tab3. */
	private Button tab3;
	
	/** The cont. */
	private DailyDealsSlideContainer cont;
	
	/** The pos. */
	public static int pos;

	/** The tab bar. */
	private LinearLayout tabBar;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.newsfeeder.custom.CustomActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dailydeals_main);
		drawerLeft = findViewById(R.id.left);
		tabBar = (LinearLayout)findViewById(R.id.tab_bar);
		tabStrip1 = findViewById(R.id.view1);
//		tabStrip2 = findViewById(R.id.view2);
//		tabStrip3 = findViewById(R.id.view3);
		tab1 = (Button)findViewById(R.id.tab1);
//		tab2 = (Button)findViewById(R.id.tab2);
//		tab3 = (Button)findViewById(R.id.tab3);
		
		setTouchNClick(R.id.tab1);
//		setTouchNClick(R.id.tab2);
//		setTouchNClick(R.id.tab3);
		tabStrip1.setBackgroundColor(Color.parseColor("#FFFF8D"));
//		tab2.setTextColor(Color.parseColor("#FFC9C3"));
//		tab3.setTextColor(Color.parseColor("#FFC9C3"));
		setupContainer();
		setActionBar();
		setupDrawer();
		setTouchNClick(R.id.signout);

	}


	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();
		tabBar.setVisibility(View.VISIBLE);
	}


	/* (non-Javadoc)
	 * @see com.dailydeals.custom.CustomActivity#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		super.onClick(v);

		if(v.getId() == R.id.tab1)
		{
			pos = 0;
			setupContainer();
			tabChanger(1);
		}
		if(v.getId() == R.id.tab2)
		{
			pos = 1;
			setupContainer();
			tabChanger(2);
		}
		if(v.getId() == R.id.tab3)
		{
			pos = 2;
			setupContainer();
			tabChanger(3);
		}
		if(v.getId() == R.id.signout)
			finish();
	}

	/**
	 * Change the Tab and Bottom strip color during selection of Tabs.
	 *
	 * @param tabNumber the tab number
	 */
	public void  tabChanger(int tabNumber)
	{
		switch(tabNumber)
		{
		case 1:
			tabStrip1.setBackgroundColor(Color.parseColor("#FFFF8D"));
			tabStrip2.setBackgroundColor(Color.parseColor("#FF5E47"));
			tabStrip3.setBackgroundColor(Color.parseColor("#FF5E47"));
			tab1.setTextColor(Color.WHITE);
			tab2.setTextColor(Color.parseColor("#FFC9C3"));
			tab3.setTextColor(Color.parseColor("#FFC9C3"));
			break;
		case 2:
			tabStrip1.setBackgroundColor(Color.parseColor("#FF5E47"));
			tabStrip2.setBackgroundColor(Color.parseColor("#FFFF8D"));
			tabStrip3.setBackgroundColor(Color.parseColor("#FF5E47"));
			tab1.setTextColor(Color.parseColor("#FFC9C3"));
			tab2.setTextColor(Color.WHITE);
			tab3.setTextColor(Color.parseColor("#FFC9C3"));
			break;
		case 3:
			tabStrip1.setBackgroundColor(Color.parseColor("#FF5E47"));
			tabStrip2.setBackgroundColor(Color.parseColor("#FF5E47"));
			tabStrip3.setBackgroundColor(Color.parseColor("#FFFF8D"));
			tab1.setTextColor(Color.parseColor("#FFC9C3"));
			tab2.setTextColor(Color.parseColor("#FFC9C3"));
			tab3.setTextColor(Color.WHITE);
			break;

		}
	}

	/**
	 * Sets the action bar.
	 */
	private void setActionBar() {
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.actionbar_bg));
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayUseLogoEnabled(false);
		actionBar.setTitle(R.string.app_name);
	}


	/**
	 * Setup the drawer layout. This method also includes the method calls for
	 * setting up the Left side drawer.
	 */
	private void setupDrawer() {
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			@Override
			public void onDrawerClosed(View view) {
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				setActionBarTitle();
			}
		};
		drawerLayout.setDrawerListener(drawerToggle);
		drawerLayout.closeDrawers();

		setupLeftNavDrawer();
	}

	/**
	 * Setup the left navigation drawer/slider. You can add your logic to load
	 * the contents to be displayed on the left side drawer. You can also setup
	 * the Header and Footer contents of left drawer if you need them.
	 */
	private void setupLeftNavDrawer() {

		ListView leeftList = (ListView) findViewById(R.id.left_drawer);
		final ArrayList<Data> al = getDummyLeftNavItems();
		adapter = new LeftNavAdapter(this, al);
		leeftList.setAdapter(adapter);
		leeftList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				drawerLayout.closeDrawers();
				tabBar.setVisibility(View.GONE);
				for(Data d : al)
					d.setSel(null);
				al.get(pos).setSel("");
				adapter.notifyDataSetChanged();
				openPage(pos);
			}
		});

	}

	/**
	 * This method returns a list of dummy items for left navigation slider. You
	 * can write or replace this method with the actual implementation for list
	 * items.
	 *
	 * @return the dummy items
	 */
	private ArrayList<Data> getDummyLeftNavItems() {

		ArrayList<Data> al = new ArrayList<Data>();
		al.add(new Data(getString(R.string.profile),
				R.drawable.icon_sidemenu_profile_normal,R.drawable.icon_sidemenu_profile_selected));
		al.add(new Data("My Purchases",
				R.drawable.icon_sidemenu_shoping_cart_normal,R.drawable.icon_sidemenu_shoping_cart_selected));

		return al;
	}

	/**
	 * This method will change the fragments when user'll select the
	 * option from left drawer.
	 *
	 * @param pos the pos
	 */
	private void openPage(final int pos)
	{
		Fragment f = null;
		String title = null;
		switch(pos)
		{

		case 0:
			f= new MyProfile();
			title = "Profile";
			break;
		case 1:
			f = new MyPurchases();
			title = "My Purchases";
			break;
		case 2:
			f = new DailyDealsSlideContainer();
			title = getString(R.string.app_name);
			break;
		}
		if(f != null)
		{
			while(getSupportFragmentManager().getBackStackEntryCount() >0)
			{
				getSupportFragmentManager().popBackStackImmediate();
			}
			if(pos==2)
				getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, f).commit();
			else
				getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, f).addToBackStack(title).commit();
		}

	}


	/**
	 * Setup the container fragment for drawer layout. The current
	 * implementation of this method simply calls launchFragment method for tab
	 * position 2 . You can customize this method as per your need to display
	 * specific content.
	 */
	private void setupContainer() {
		getSupportFragmentManager().addOnBackStackChangedListener(new OnBackStackChangedListener() {

			@Override
			public void onBackStackChanged() {
				setActionBarTitle();
			}
		});
		tabBar.setVisibility(View.VISIBLE);
		openPage(2);
	}

	/**
	 * Set the action bar title text.
	 */
	private void setActionBarTitle()
	{
		if (getSupportFragmentManager().getBackStackEntryCount() == 0)
		{
			getActionBar().setTitle(R.string.app_name);
			return;
		}
		String title = getSupportFragmentManager().getBackStackEntryAt(
				getSupportFragmentManager().getBackStackEntryCount() - 1)
				.getName();
		getActionBar().setTitle(title==null?getString(R.string.app_name):title);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see android.app.Activity#onPostCreate(android.os.Bundle)
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		drawerToggle.syncState();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * android.app.Activity#onConfigurationChanged(android.content.res.Configuration
	 * )
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggle
		drawerToggle.onConfigurationChanged(newConfig);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.newsfeeder.custom.CustomActivity#onOptionsItemSelected(android.view
	 * .MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.search, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see android.support.v4.app.FragmentActivity#onKeyDown(int,
	 * android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			drawerLayout.closeDrawers();
			setupLeftNavDrawer();
			if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
				getSupportFragmentManager().popBackStackImmediate();
				setupContainer();
			}
			else
				finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.food.custom.CustomActivity#onClick(android.view.View)
	 */
	/*
	 * @Override public void onClick(View v) { super.onClick(v); if (v.getId()
	 * == R.id.logout) { startActivity(new Intent(this, Login.class)); finish();
	 * } }
	 */
}
