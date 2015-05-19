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
import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.Switch;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 *
 * Simple Activity that will allow the user to show/hide the
 * overlay view.
 *
 * Created by Arnaud Ruffin on 17/03/15.
 */
@SuppressLint("Registered")
@EActivity(R.layout.activity)
public class MyActivity extends Activity {

    @Bean
    protected ViewHolder holder;

    @ViewById(R.id.switch_view)
    protected Switch aSwitch;

    @AfterViews
    protected void init() {
        //when initializing the activity, set the switch state according to the singleton state
        aSwitch.setChecked(holder.isShown());
    }

    @CheckedChange(R.id.switch_view)
    protected void checkedChangeOnSwitch(boolean isChecked) {
        // called whenever the switch is touched
        if (isChecked) {
            ViewService_.intent(getApplication()).showMask().start();
        } else {
            ViewService_.intent(getApplication()).hideMask().start();
        }
    }

    @Click(R.id.link_to_licenses)
    public void openLicenseDialog(){
        (new AlertDialog.Builder(this))
                .setTitle("Licences")
                .setView(LayoutInflater.from(this).inflate(R.layout.license_dialog, null))
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok,null)
                .create().show();
    }


}
