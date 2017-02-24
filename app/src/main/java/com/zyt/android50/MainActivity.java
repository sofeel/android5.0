package com.zyt.android50;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.zyt.android50.customwidgets.ui.Activity1_5;
import com.zyt.android50.customwidgets.ui.Activity1_6;
import com.zyt.android50.customwidgets.ui.Activity1_7;
import com.zyt.android50.customwidgets.ui.Activity1_8;
import com.zyt.android50.customwidgets.ui.Activity1_9;
import com.zyt.android50.customwidgets.ui.FlipperActivity;
import com.zyt.android50.customwidgets.ui.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private View viewToAnimate;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_main);
        findViewById(R.id.toggleButton).setOnClickListener(this);
        viewToAnimate = findViewById(R.id.theView);
        findViewById(R.id.layoutTransition).setOnClickListener(this);
        findViewById(R.id.multiLayout).setOnClickListener(this);
        findViewById(R.id.emptyLayout).setOnClickListener(this);
        findViewById(R.id.selctionHerder).setOnClickListener(this);
        findViewById(R.id.fragmentAnimation).setOnClickListener(this);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setTitle("主题");
//        actionBar.setSubtitle("副主题");

//        ImageView imageView = new ImageView(this);
//        imageView.setImageResource(R.drawable.jiekua_hunhejie);
//        imageView.setScaleType(ImageView.ScaleType.CENTER);
//
//        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
//        actionBar.setCustomView(imageView, layoutParams);

//        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);

    }

//    @Override
//    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        mToolbar.setTitle("zhuti");
//        mToolbar.setSubtitle("fu zhuti");
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.support, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }

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
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggleButton:
                if (viewToAnimate.getAlpha() > 0f) {
                    viewToAnimate.animate().alpha(0f).translationX(1000f);
                } else {
                    viewToAnimate.setTranslationX(0f);
                    viewToAnimate.animate().alpha(1f);
                }

                EventBus.getDefault().post(new MessageEvent("hello word!!"));
                startActivity(new Intent(MainActivity.this, FlipperActivity.class));
                break;

            case R.id.layoutTransition:
                startActivity(new Intent(MainActivity.this, Activity1_5.class));
                break;
            case R.id.multiLayout:
                startActivity(new Intent(MainActivity.this, Activity1_6.class));
                break;
            case R.id.emptyLayout:
                startActivity(new Intent(MainActivity.this, Activity1_7.class));
                break;
            case R.id.selctionHerder://自定义过度动画
                startActivity(new Intent(MainActivity.this, Activity1_8.class));
//                overridePendingTransition(R.anim.open_enter,R.anim.open_exit);
//                finish();
//                overridePendingTransition(R.anim.close_enter,R.anim.close_exit);
                break;
            case R.id.fragmentAnimation:
                startActivity(new Intent(MainActivity.this, Activity1_9.class));
                break;
            default:
                break;
        }
    }
}
