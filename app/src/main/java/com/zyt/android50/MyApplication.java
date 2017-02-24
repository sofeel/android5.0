package com.zyt.android50;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

import java.io.Closeable;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by user on 2017/2/15.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Realm
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }
}
