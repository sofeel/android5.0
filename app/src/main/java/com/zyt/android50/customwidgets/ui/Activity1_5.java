package com.zyt.android50.customwidgets.ui;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zyt.android50.R;

/**
 *布局变动时动画
 * Created by user on 2017/2/22.
 */

public class Activity1_5 extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_5);

        findViewById(R.id.button_add).setOnClickListener(this);
        mContainer = (LinearLayout) findViewById(R.id.verticalCotainer);
        LayoutTransition transition = new LayoutTransition();
        mContainer.setLayoutTransition(transition);
        //自定义动画
        ObjectAnimator appearAnim = ObjectAnimator.ofFloat(null, "rotationY", 90f, 0f)//进入
                .setDuration(transition.getDuration(LayoutTransition.APPEARING));
        transition.setAnimator(LayoutTransition.APPEARING,appearAnim);
        ObjectAnimator disppearAnim = ObjectAnimator.ofFloat(null, "rotationX", 0f, 90f)//消失
                .setDuration(transition.getDuration(LayoutTransition.DISAPPEARING));
        transition.setAnimator(LayoutTransition.DISAPPEARING,disppearAnim);

        PropertyValuesHolder pvhSlide = PropertyValuesHolder.ofFloat("y", 0, 1);//侧滑属性动画
        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.5f,1f);//y缩放
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.5f,1f);//x缩放
        ObjectAnimator changingAppearingAnim = ObjectAnimator.ofPropertyValuesHolder(this, pvhSlide, pvhScaleY, pvhScaleX)
                .setDuration(transition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,changingAppearingAnim);


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
