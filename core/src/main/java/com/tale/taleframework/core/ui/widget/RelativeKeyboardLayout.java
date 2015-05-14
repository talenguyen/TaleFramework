package com.tale.taleframework.core.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import timber.log.Timber;

/**
 * Created by tale on 5/7/15.
 */
public class RelativeKeyboardLayout extends RelativeLayout {

    public static interface KeyboardEventListener {

        void onChanged(boolean show);

    }

    private KeyboardEventListener keyboardEventListener;

    public void setKeyboardEventListener(
            KeyboardEventListener keyboardEventListener) {
        this.keyboardEventListener = keyboardEventListener;
    }

    public RelativeKeyboardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Timber.d("onSizeChanged => {w=%d, h=%d, oldw=%d, oldh=%d}", w, h, oldw, oldh);
        if (keyboardEventListener != null && oldh != 0) {
            final boolean show = (h + 50) < oldh;
            Timber.d("onKeyboardShow: %s", show);
            keyboardEventListener.onChanged(show);
        }
    }
}
