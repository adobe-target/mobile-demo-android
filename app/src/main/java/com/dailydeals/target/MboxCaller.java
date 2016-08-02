package com.dailydeals.target;

import com.adobe.mobile.Target;
import com.adobe.mobile.TargetLocationRequest;

import java.util.HashMap;
import java.util.Map;


public class MboxCaller {

    // This is a helper function to male Target location(mbox) call
    public static void makeMboxCall(String mbox,
                                    String defaultContent,
                                    Map<String, Object> parameters,
                                    Target.TargetCallback<String> targetCallback) {

        TargetLocationRequest locationRequest = Target.createRequest(mbox, defaultContent, parameters);
        Target.loadRequest(locationRequest, targetCallback);
    }


    // This is a helper function to male Target success metric call
    public static void makeMboxConfirm(String name,
                                       String orderId,
                                       String orderTotal,
                                       String productPurchasedId,
                                       Map<String, Object> parameters,
                                       Target.TargetCallback<String> targetCallback) {


        TargetLocationRequest orderConfirm = Target.createOrderConfirmRequest(name, orderId, orderTotal, productPurchasedId, parameters);
        Target.loadRequest(orderConfirm, targetCallback);
    }

}
