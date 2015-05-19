/*
 * Simiasque
 * Copyright (C) 2015 Orange
 * Authors: arnaud.ruffin@orange.com
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.thisisafactory.simiasque;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.ServiceAction;
import org.androidannotations.annotations.SystemService;

/**
 * A service that will be in charge of creating the view and hiding/showing it. This is the entry point.
 *
 * Created by Arnaud Ruffin on 17/03/15.
 */
@SuppressLint("Registered")
@EIntentService
public class ViewService extends IntentService {

    private static final int SAFETY_MARGIN = 20;

    @SystemService
    protected WindowManager windowManager;

    @Bean
    protected ViewHolder holder;

    public ViewService() {
        super(ViewService.class.getSimpleName());
    }

    @AfterInject
    public void init() {
        if (holder.getCurrentOverlay() == null) {
            View overlayView = new OverlayView(this);
            windowManager.addView(overlayView, OverlayView.createLayoutParams(retrieveStatusBarHeight() + SAFETY_MARGIN));
            holder.setCurrentOverlay(overlayView);
        }
        holder.hideView();
    }

    public int retrieveStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @ServiceAction
    protected void showMask() {
        holder.showView();
    }


    @ServiceAction
    protected void hideMask() {
        holder.hideView();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Do nothing here
    }


}