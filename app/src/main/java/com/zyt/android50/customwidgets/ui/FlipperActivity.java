package com.zyt.android50.customwidgets.ui;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.zyt.android50.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class FlipperActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean mIsHeads;
    private AnimatorSet mFlipper;
    private Bitmap mHeadsImage, mTailsImage;
    private ImageView mFlipImage;


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }


    //    @Subscribe(threadMode = ThreadMode.MAIN)
    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, event.msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_flip);
        mHeadsImage = BitmapFactory.decodeResource(getResources(), R.drawable.head);
        mTailsImage = BitmapFactory.decodeResource(getResources(), R.drawable.tails);
        mFlipImage = (ImageView) findViewById(R.id.flip_image);
        mFlipImage.setImageBitmap(mHeadsImage);
        mIsHeads = true;

//        mFlipper = ObjectAnimator.ofFloat(mFlipImage, "rotationY", 0f, 360f);
        mFlipper = (AnimatorSet)AnimatorInflater.loadAnimator(this, R.animator.flip);
        mFlipper.setTarget(mFlipImage);
        ObjectAnimator animator = (ObjectAnimator)mFlipper.getChildAnimations().get(0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i("onAnimationUpdate", animation.getAnimatedFraction() + ":" + animation.getAnimatedValue());
                if (animation.getAnimatedFraction() >= 0.25f && mIsHeads) {
                    mFlipImage.setImageBitmap(mTailsImage);
                    mIsHeads = false;
                }
                if (animation.getAnimatedFraction() >= 0.75f && !mIsHeads) {
                    mFlipImage.setImageBitmap(mHeadsImage);
                    mIsHeads = true;
                }
            }
        });

        mFlipper.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i("mFlipper Animator", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("mFlipper Animator", "onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i("mFlipper Animator", "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i("mFlipper Animator", "onAnimationRepeat");
            }
        });

        ListView listView = new ListView(this);
        listView.setEmptyView(null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mFlipper.start();
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void onToggleMode(View v) {
        //夜间模式切换
//        int currentVis = v.getSystemUiVisibility();
//        int newVis;
//        if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE)
//                == View.SYSTEM_UI_FLAG_LOW_PROFILE) {
//            newVis = View.SYSTEM_UI_FLAG_VISIBLE;
//        }else {
//            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE;
//        }
//        v.setSystemUiVisibility(newVis);

//        //隐藏导航（home ,back）
//        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        //隐藏系统状态栏和actionBar以及全屏显示
//        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

//        getActionBar().hide();//...

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggleButton:
                break;
            default:
                break;
        }
    }
}
