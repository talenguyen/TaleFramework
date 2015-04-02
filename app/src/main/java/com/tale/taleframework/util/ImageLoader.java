package com.tale.taleframework.util;

import android.widget.ImageView;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public interface ImageLoader {

    void load(String url, ImageView target, int errorId);

    void load(String url, ImageView target, int errorId, Object tag);

    void pauseTag(Object tag);

    void resumeTag(Object tag);

    void cancelTag(Object tag);
}
