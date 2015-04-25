/*
 * Copyright (c) 2014 Giang Nguyen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tale.taleframework.core.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by tale on 11/8/14.
 */
public abstract class BaseActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies();

        final int layoutId = getContentViewId();
        if (layoutId == 0) {
            final View contentView = getContentView();
            if (contentView != null) {
                setContentView(contentView);
                injectViews();
            }
        } else {
            setContentView(layoutId);
            injectViews();
        }

    }

    /**
     * Create content view, this is fallback method to create content view if getContentViewId() method return 0.
     *
     * @return Content View.
     */
    protected View getContentView() {
        return null;
    }

    /**
     * Return layout's id to be set on setContentView(int layoutId) method.
     *
     * @return layout's id or 0 to use getContentView().
     */
    protected abstract int getContentViewId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract void injectDependencies();

    /**
     * Use to inject views which declared by using Annotation @InjectView.
     */
    protected void injectViews() {
        ButterKnife.inject(this);
    }
}