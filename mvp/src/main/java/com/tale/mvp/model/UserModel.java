package com.tale.mvp.model;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public interface UserModel {

    @GET("/users")
    Observable<List<User>> getUsers();

    @GET("/users/{username}")
    Observable<User> getUser(@Path("username") String username);
}
