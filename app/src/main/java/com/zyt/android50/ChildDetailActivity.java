package com.zyt.android50;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;

/**
 * Created by user on 2017/2/15.
 */

public class ChildDetailActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try (Realm realm = Realm.getDefaultInstance()) {
            // No need to close the Realm instance manually
        }

    }
}
