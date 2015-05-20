package org.thisisafactory.simiasque;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.androidannotations.annotations.EReceiver;
import org.androidannotations.annotations.ReceiverAction;

/**
 * Broadcast receive for toggling Simiasque.
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

    /*
    @ReceiverAction
    void anotherAction(@ReceiverAction.Extra("specialExtraName") String valueString, @ReceiverAction.Extra long valueLong) {
        // ...
    }
*/
/*
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
    }*/
}
