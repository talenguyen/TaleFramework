package com.tale.mvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class User {
    @SerializedName("login") public String login;//": "octocat",
    @SerializedName("id") public String id;//": 1,
    @SerializedName("avatar_url") public String avatar_url;//": "https://github.com/images/error/octocat_happy.gif",
}
