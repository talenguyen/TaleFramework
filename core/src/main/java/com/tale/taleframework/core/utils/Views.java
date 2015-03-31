package com.tale.taleframework.core.utils;

import android.app.Activity;
import android.view.View;

/**
 * Created by Larry on 3/31/2015.
 */
public class Views {

    public static <T extends View> T findViewById(View source, int resId) {
        return (T) source.findViewById(resId);
    }

    public static <T extends View> T findViewById(Activity source, int resId) {
        return (T) source.findViewById(resId);
    }
}
