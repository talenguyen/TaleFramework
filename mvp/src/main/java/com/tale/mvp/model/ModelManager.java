package com.tale.mvp.model;

import retrofit.RestAdapter;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class ModelManager {

    public static final String BASE_URL = "https://api.github.com";

    public static UserModel getGitUserModel() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        return restAdapter.create(UserModel.class);
    }
}
