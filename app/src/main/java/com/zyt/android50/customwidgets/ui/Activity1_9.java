package com.zyt.android50.customwidgets.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zyt.android50.R;

/**
 * 构建多个布局文件
 * Created by user on 2017/2/22.
 */

public class Activity1_9 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_9);

//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.setCustomAnimations
//                (R.anim.open_enter,
//                        R.anim.open_exit,
//                        R.anim.close_enter,
//                        R.anim.close_exit)
//                .replace(R.id.container_fragment, new SupportFragment())
//                .addToBackStack(null)
//                .commit();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container_fragment, new SupportFragment())
                .addToBackStack(null)
                .commit();


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add:
                break;
            default:
                break;
        }
    }
}
