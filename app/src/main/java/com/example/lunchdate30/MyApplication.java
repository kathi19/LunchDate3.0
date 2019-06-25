package com.example.lunchdate30;

import android.app.Application;

public class MyApplication extends Application {

    private String[] userData;

    public String[] getUserData() {
        return userData;
    }

    public void setUserData(String[] someVariable) {
        this.userData = someVariable;
    }
}
