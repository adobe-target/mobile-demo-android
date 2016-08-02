package com.dailydeals.custom;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;

import com.dailydeals.custom.CustomActivity;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomFragment.
 */
public class CustomFragment extends Fragment implements OnClickListener
{

	/**
	 * Set the touch and click listener for a View.
	 * 
	 * @param v
	 *            the view
	 * @return the same view
	 */
	public View setTouchNClick(View v)
	{

		v.setOnClickListener(this);
		v.setOnTouchListener(CustomActivity.TOUCH);
		return v;
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v)
	{

	}
}
