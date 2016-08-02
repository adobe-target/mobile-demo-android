package com.dailydeals.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.dailydeals.R;
import com.dailydeals.custom.CustomFragment;

// TODO: Auto-generated Javadoc
/**
 * The Class MyProfile.
 */
public class MyProfile extends CustomFragment{

	/** The Notication Checkbox. */
	private CheckBox notification ;
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.profile, null);
		notification = (CheckBox)v.findViewById(R.id.chk1);
		notification.setChecked(true);
		setTouchNClick(v.findViewById(R.id.btn_signout));
		setHasOptionsMenu(true);
		return v;
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateOptionsMenu(android.view.Menu, android.view.MenuInflater)
	 */
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

		super.onCreateOptionsMenu(menu, inflater);
		menu.clear();
		inflater.inflate(R.menu.edit, menu);
	}
	

}
