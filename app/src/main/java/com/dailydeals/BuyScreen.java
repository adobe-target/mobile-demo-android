package com.dailydeals;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dailydeals.custom.CustomActivity;

// TODO: Auto-generated Javadoc
/**
 * This class contains the details for the deal which 
 * is selected by the user.
 */
public class BuyScreen extends CustomActivity{

	/** The Title for Action Bar. */
	private static String title;
	
	/** The Doller Price. */
	private TextView dollerPrice;
	
	/* (non-Javadoc)
	 * @see com.dailydeals.custom.CustomActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buy_screen_main);
		title = getIntent().getExtras().getString("title");
		dollerPrice = (TextView)findViewById(R.id.doller_strike);
		dollerPrice.setPaintFlags(dollerPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
		setTouchNClick(R.id.btn_cart);
		getActionBar().setTitle(title);
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.dailydeals.custom.CustomActivity#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v.getId() == R.id.btn_cart)
			startActivity(new Intent(this,Coupon.class));
	}

	/* (non-Javadoc)
	 * @see com.dailydeals.custom.CustomActivity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}

		return super.onOptionsItemSelected(item);
	}
	
	
	
	

}
