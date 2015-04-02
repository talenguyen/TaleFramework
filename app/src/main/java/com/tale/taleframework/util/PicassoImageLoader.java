package com.tale.taleframework.util;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class PicassoImageLoader implements ImageLoader {

    private final Picasso picasso;

    public PicassoImageLoader(Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    public void load(String url, ImageView target, int errorId) {
        picasso.load(url).fit().centerCrop().error(errorId).into(target);
    }

    @Override
    public void load(String url, ImageView target, int errorId, Object tag) {
        picasso.load(url).fit().centerCrop().error(errorId).tag(tag).into(target);
    }

    @Override
    public void pauseTag(Object tag) {
        picasso.pauseTag(tag);
    }

    @Override
    public void resumeTag(Object tag) {
        picasso.resumeTag(tag);
    }

    @Override
    public void cancelTag(Object tag) {
        picasso.cancelTag(tag);
    }
}
