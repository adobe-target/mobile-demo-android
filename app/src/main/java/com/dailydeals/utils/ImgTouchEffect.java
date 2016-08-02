package com.dailydeals.utils;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

// TODO: Auto-generated Javadoc
/**
 * The Class TouchEffect is the implementation of OnTouchListener interface. You
 * can apply this to views mostly Buttons to provide Touch effect and that view
 * must have a valid background. The current implementation simply set Alpha
 * value of View background.
 */
public class ImgTouchEffect implements OnTouchListener
{

	/* (non-Javadoc)
	 * @see android.view.View.OnTouchListener#onTouch(android.view.View, android.view.MotionEvent)
	 */
	@Override
	public boolean onTouch(View v, MotionEvent event)
	{
		ImageView img = (ImageView) v;
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			img.setColorFilter(Color.parseColor("#c2ebf9"),
					PorterDuff.Mode.MULTIPLY);
			//img.setAlpha(0.7f);
		}
		else if (event.getAction() == MotionEvent.ACTION_UP
				|| event.getAction() == MotionEvent.ACTION_CANCEL)
		{
			img.setColorFilter(0);
			//img.setAlpha(1f);
		}
		return false;
	}

}
