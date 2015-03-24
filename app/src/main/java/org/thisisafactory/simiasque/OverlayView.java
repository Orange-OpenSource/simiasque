package org.thisisafactory.simiasque;

import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;

import static android.graphics.PixelFormat.TRANSLUCENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
import static android.view.WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
import static android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
import static android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
import static android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
import static android.view.WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;

/**
 * The layout that will be used to cover the status bar
 *
 * Created by Arnaud Ruffin on 17/03/15
 */
final class OverlayView extends FrameLayout {

    public OverlayView(Context context) {
        super(context);
        inflate(context, R.layout.overlay_view, this);
    }

    static WindowManager.LayoutParams createLayoutParams(int height) {
        final WindowManager.LayoutParams params =
                new WindowManager.LayoutParams(MATCH_PARENT, height, TYPE_SYSTEM_ERROR, FLAG_NOT_FOCUSABLE
                        | FLAG_LAYOUT_IN_SCREEN
                        | FLAG_LAYOUT_NO_LIMITS
                        | FLAG_NOT_TOUCH_MODAL
                        | FLAG_LAYOUT_INSET_DECOR
                       , TRANSLUCENT);
        params.gravity = Gravity.TOP;
        return params;
    }
}
