package com.tale.taleframework.ui.activities;

import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tale.taleframework.R;
import com.tale.taleframework.core.ui.activities.BaseActivity;
import com.tale.taleframework.loader.DataLoader;
import com.tale.taleframework.loader.Loader;
import com.tale.taleframework.loader.Observer;
import com.tale.taleframework.services.StringLoaderService;

import butterknife.InjectView;

/**
 * Created by tale on 3/10/15.
 */
public class StringLoaderActivity extends BaseActivity implements Observer<String> {

    @InjectView(R.id.progressBar) ProgressBar progressBar;
    @InjectView(R.id.tvResult) TextView tvResult;
    DataLoader<String> loader = Loader.StringLoader.asDataLoader();

    @Override protected int getContentViewId() {
        return R.layout.activity_string_loader;
    }

    @Override protected void onStart() {
        super.onStart();
        startService(new Intent(this, StringLoaderService.class));
    }

    @Override protected void onResume() {
        super.onResume();
        loader.register(this.getClass().getName(), this);
    }

    @Override protected void onPause() {
        super.onPause();
        loader.unRegister(this.getClass().getName());
    }

    @Override protected Object[] getModules() {
        return new Object[]{new Module()};
    }

    @Override public void onBeforeResult() {
        showProgress(true);
    }

    @Override public void onResult(String s) {
        tvResult.setText(s);
    }

    @Override public void onError(Throwable throwable) {
        Toast.makeText(this, "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override public void onCompleted() {
        showProgress(false);
    }

    private void showProgress(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        tvResult.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    @dagger.Module(
            injects = StringLoaderActivity.class,
            complete = false
    )
    public static class Module {
    }

}
