package com.dailydeals;

import com.adobe.mobile.Config;
import com.adobe.mobile.Target;
import com.dailydeals.target.MboxCaller;

import com.dailydeals.custom.CustomActivity;
import com.dailydeals.DailyDeal;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static android.widget.GridLayout.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Login is an Activity class that shows the login screen to users.
 * The current implementation simply start the MainActivity. You can write your
 * own logic for actual login and for login using Facebook and Twitter.
 */
public class Login extends CustomActivity {

	/** The signup. */
	private Button signup;
	
	/* (non-Javadoc)
	 * @see com.dailydeals.custom.CustomActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		Config.setContext(this.getApplicationContext());
		Config.setDebugLogging(true);


		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		signup = (Button)findViewById(R.id.signup);
	    setTouchNClick(R.id.btn_email);
	    setTouchNClick(R.id.btn_forgot);
	    setTouchNClick(R.id.btnfb);
	    setTouchNClick(R.id.btntw);
	    setTouchNClick(R.id.signup);
	    signup.setText("");


		Map<String, String> userData = new HashMap<String, String>();
        userData.put("account_type", "Regular");
        userData.put("savings","true");
        userData.put("checking_balance","10000");
        userData.put("user_cohort", "5");

		System.out.print(userData);


		MboxCaller.makeMboxCall("new-welcome-message",
                "Default Message", Collections.<String, Object>emptyMap(),
                new Target.TargetCallback<String>() {

                    @Override
                    public void call(final String content) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.d("-----new-welcome-message----", content);
                                if (!content.equals("Default Message")) {
                                    signup.setText(content);
                                }
                            }
                        });
                    }
                });

		MboxCaller.makeMboxCall("social-signup",
				"Default Message", Collections.<String, Object>emptyMap(),
				new Target.TargetCallback<String>() {

					View tw = findViewById(R.id.btntw);
					View fb = findViewById(R.id.btnfb);



					@Override
					public void call(final String content) {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								Log.d("----social-signup----", content);

								if (content.equals("no-social")){
									tw.setVisibility(View.INVISIBLE);
									fb.setVisibility(View.INVISIBLE);
								} else if (content.equals("fb")) {
									tw.setVisibility(View.INVISIBLE);

								} else if (content.equals("tw")) {
									fb.setVisibility(View.INVISIBLE);
								}
							}
						});
					}
				});


		MboxCaller.makeMboxConfirm("confirm_mbox_call", "order", "3.00", null, null, null);

	}

	/* (non-Javadoc)
	 * @see com.dailydeals.custom.CustomActivity#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v)
	{
		
		if (v.getId() != R.id.signup)
		{
			startActivity(new Intent(this.getApplicationContext(), DailyDeal.class));
			finish();
		}
	}
	
}
