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

package com.tale.taleframework.core.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.tale.taleframework.core.BaseApp;

/**
 * Created by tale on 11/8/14.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseApp.getRefWatcher(getActivity()).watch(this);
    }

    protected void injectDependencies() {
    }

}
