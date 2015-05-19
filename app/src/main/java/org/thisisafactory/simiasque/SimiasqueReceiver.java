package org.thisisafactory.simiasque;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Broadcast receive for toggling Simiasque.
 */
public class SimiasqueReceiver extends BroadcastReceiver {

    public static final String EXTRA_ENABLE = "enable";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("org.thisisafactory.simiasque.SET_OVERLAY")) {
            if (intent.hasExtra(EXTRA_ENABLE)) {
                boolean enable = intent.getBooleanExtra(EXTRA_ENABLE, false);
                if (enable) {
                    ViewService_.intent(context).showMask().start();
                } else {
                    ViewService_.intent(context).hideMask().start();
                }
            } else {
                Log.i("Simiasque", "Missing EXTRA_ENABLE in broadcast");
            }
        }
    }
}
