package com.zyt.android50.customwidgets.ui;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zyt.android50.R;

/**
 *构建多个布局文件
 * Created by user on 2017/2/22.
 */

public class Activity1_6 extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_6);

        findViewById(R.id.button_add).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add:
                Button button = new Button(this);
                button.setText("click to  remove");
                button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContainer.removeView(v);
                }
            });
                mContainer.addView(button,
                        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                break;
            default:
                break;
        }
    }
}
