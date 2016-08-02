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



//        Passing custom parameters for targeting. In this example, the parameters are
//        hardcoded but typically variables should be used for sending custom profile information.

//        Keys with the prefix profile (eg: profile.gender) are stored on the user's profile.
//        These profile attributes can be used across different activities and channels.

//        Keys that don't have any prefix (eg: userMiles) are mbox parameters.
//        These parameters are available only during the session.

//        Keys with the prefix entity (eg: entity.category.id) are used for product recommendations.



        Map<String, Object> targetParams = new HashMap<String, Object>();
        targetParams.put("male", "profile.gender");
        targetParams.put("platinum", "profile.memberLevel");
        targetParams.put("true", "loyaltyAccount");
        targetParams.put("abcd1234", "mbox3rdPartyId"); // mbox3rdPartyId is a reserved key where you can pass your crm/internal user id
        targetParams.put("android.dev", "env");         // The value (eg: ios.prod) needs to be dynamic based on the app environment.
                                                        // This is used for building audiences for testing


        // Here 'welcome-message-rp' is the name of the location. This will show up in the content
        // location dropdown in the UI.


        // See the MboxCaller class or examples and methods in this page
        // https://marketing.adobe.com/resources/help/en_US/mobile/android/c_target_methods.html

		MboxCaller.makeMboxCall("welcome-message-rp",
                "default.png", targetParams,
                new Target.TargetCallback<String>() {

                    @Override
                    public void call(final String content) {

                        // It is typically a bad practice to run on the main thread! This is just for the demo.
                        // In your production app, get this content without blocking, typically before the view is rendered
                        // so that the end user won't see a flicker when new content is inserted or replaced.

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.d("welcome-message-rp----", content);
                                if (!content.equals("Default Message")) {
                                    signup.setText(content);
                                }
                            }
                        });
                    }
                });

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

            MboxCaller.makeMboxConfirm("user-signed-up", "12345", "90.50", "abcd, efgh", null, null);
			finish();
		}
	}
	
}
