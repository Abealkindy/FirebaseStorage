package com.rosinante24.firebasestorage;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Rosinante24 on 05/10/17.
 */
@IgnoreExtraProperties
public class Upload {

    public String name;
    public String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Upload(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Upload() {

    }
}
