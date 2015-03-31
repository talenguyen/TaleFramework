package com.tale.taleframework.core.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tale.taleframework.core.R;
import com.tale.taleframework.core.utils.Views;

/**
 * Created by Larry on 3/31/2015.
 */
public class NoNetworkView extends RelativeLayout {

    private ImageView ivIcon;

    public NoNetworkView(Context context, AttributeSet attrs,
                         int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.view_no_network, this);
    }

    public NoNetworkView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NoNetworkView(Context context) {
        this(context, null, 0);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ivIcon = Views.findViewById(this, R.id.ivIcon);
    }

    public ImageView getIconView() {
        return ivIcon;
    }
}
