package com.tale.mvp.presenter;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public interface BasePresenter<V, M> {

    /**
     * Start the presenter
     */
    void onStart(V view, M model);


    /**
     * Stop the presenter
     */
    public void onStop();

}
