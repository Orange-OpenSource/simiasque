/*
 * Simiasque
 * Copyright (C) 2015 Orange
 * Authors: Mads Kalør, Arnaud Ruffin
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.thisisafactory.simiasque;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.androidannotations.annotations.EReceiver;
import org.androidannotations.annotations.ReceiverAction;

/**
 * Broadcast receiver for toggling Simiasque.
 */
@EReceiver
public class SimiasqueReceiver extends BroadcastReceiver {

    public static final String EXTRA_ENABLE = "enable";

    @ReceiverAction("org.thisisafactory.simiasque.SET_OVERLAY")
    void toggle(Context context, @ReceiverAction.Extra(EXTRA_ENABLE) boolean enable) {
        if (enable) {
            ViewService_.intent(context).showMask().start();
        } else {
            ViewService_.intent(context).hideMask().start();
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // empty, will be overridden in generated subclass
    }


}
