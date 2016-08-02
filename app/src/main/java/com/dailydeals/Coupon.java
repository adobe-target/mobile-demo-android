package com.dailydeals;

import android.os.Bundle;
import android.view.View;

import com.dailydeals.custom.CustomActivity;

// TODO: Auto-generated Javadoc
/**
 * This class holds the coupon details , the QR cade for 
 * Redeem  and the coupon code .
 * This Activity will open as a dialog .
 */
public class Coupon extends CustomActivity{

	
	/* (non-Javadoc)
	 * @see com.dailydeals.custom.CustomActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coupon);
		setTouchNClick(R.id.btn_close);
	}

	/* (non-Javadoc)
	 * @see com.dailydeals.custom.CustomActivity#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v.getId() == R.id.btn_close)
			finish();
	}
	

}
