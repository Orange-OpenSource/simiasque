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

import android.view.View;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

/**
 * A singleton that will hold a reference to our overlay,
 * so that we can easily show/hide or retrieve it.
 *
 * Created by Arnaud Ruffin on 17/03/15.
 */
@EBean(scope = EBean.Scope.Singleton)
public class ViewHolder {

    protected View currentOverlay;

    protected boolean shown;

    @UiThread
    protected void showView() {
        currentOverlay.setVisibility(View.VISIBLE);
        shown = true;
    }

    @UiThread
    protected void hideView() {
        currentOverlay.setVisibility(View.GONE);
        shown = false;
    }

    public void setCurrentOverlay(View currentOverlay) {
        this.currentOverlay = currentOverlay;
    }

    public View getCurrentOverlay() {
        return currentOverlay;
    }

    public boolean isShown() {
        return shown;
    }

}
