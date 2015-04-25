package com.tale.taleframework.core.di;

import android.app.Activity;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.  Activity-level components
 * should extend this component.
 */
@PerActivity // Subtypes of ActivityComponent should be decorated with @PerActivity.
@Component(modules = ActivityModule.class)
public interface AbstractActivityComponent {
    Activity activity(); // Expose the activity to sub-graphs.
}