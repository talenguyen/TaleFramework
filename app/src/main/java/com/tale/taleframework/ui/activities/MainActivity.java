package com.tale.taleframework.ui.activities;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.tale.taleframework.R;
import com.tale.taleframework.core.publishers.RxBus;
import com.tale.taleframework.core.ui.activities.BaseActivity;
import com.tale.taleframework.services.Intent1;
import com.tale.taleframework.services.Intent2;

import javax.inject.Inject;

import butterknife.InjectView;
import rx.Subscription;
import rx.android.app.AppObservable;
import timber.log.Timber;


public class MainActivity extends BaseActivity {

    @Inject RxBus bus;
    @InjectView(R.id.tvCount) TextView tvCount;
    private int count;
    private Subscription countSubscription;

    @Override protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override protected Object[] getModules() {
        return new Object[]{new Module()};
    }

    @Override protected void onResume() {
        super.onResume();
        countSubscription = AppObservable.bindActivity(this, bus.asObservable())
                .map(t -> {
                    Timber.d("t: %s", t);
                    return String.valueOf(t);
                })
                .map(status -> {
                    Timber.d("status: %s", status);
                    if (status.equals("started")) {
                        return ++count;
                    } else {
                        return --count;
                    }
                })
                .map(count -> String.valueOf(count))
                .subscribe(countString -> {
                    Timber.d("count: %s", countString);
                    tvCount.setText(countString);
                });
    }

    @Override protected void onPause() {
        super.onPause();
        if (countSubscription != null) {
            countSubscription.unsubscribe();
        }
    }

    @Override protected void onStart() {
        super.onStart();
        start2InstanceOfIntent1();
    }

    private void start2InstanceOfIntent1() {
        startService(new Intent(this, Intent1.class));
        startService(new Intent(this, Intent2.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @dagger.Module(
            injects = MainActivity.class,
            complete = false
    )
    public static class Module {
    }
}
