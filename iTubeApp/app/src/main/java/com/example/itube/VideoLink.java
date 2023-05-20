package com.example.itube;

import android.database.Cursor;

import java.io.Serializable;

public class VideoLink implements Serializable {
    private String id;
    private String url;

    public VideoLink(String id, String url) {
        this.url = url;
        this.id = id;
    }

    public VideoLink(Cursor cursor) {
        this.url = cursor.getString(1);
        this.id = cursor.getString(0);
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

}
