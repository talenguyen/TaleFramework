package com.tale.taleframework.ui.activities;

import android.os.Bundle;
import android.widget.Button;

import com.tale.taleframework.R;
import com.tale.taleframework.core.ui.activities.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Larry on 3/31/2015.
 */
public class TestFragmentActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btLoading) public void onLoadingClick() {

    }

}
