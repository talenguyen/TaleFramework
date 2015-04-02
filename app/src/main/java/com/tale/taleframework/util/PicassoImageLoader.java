package com.tale.taleframework.util;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class PicassoImageLoader implements ImageLoader {

    @Inject public PicassoImageLoader() {
    }

    @Override
    public void load(String url, ImageView target) {
        Picasso.with(target.getContext()).load(url).fit().centerCrop().into(target);
    }
}
