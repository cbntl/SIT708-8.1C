package com.example.itube;

import android.database.Cursor;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String name;
    private String username;
    private String password;
    public User(String id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(Cursor cursor) {
        this.id = cursor.getString(0);
        this.name = cursor.getString(1);
        this.username = cursor.getString(2);
        this.password = cursor.getString(3);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }


}

