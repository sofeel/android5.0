package com.zyt.android50.customwidgets.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 2017/2/23.
 */

public class TextImageButton extends FrameLayout {

    private ImageView mImageView;
    private TextView mTextView;

    public TextImageButton(Context context) {
        this(context, null);
    }

    public TextImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        //传递按钮样
        super(context, attrs, defStyleAttr);
//        super(context, attrs, android.R.attr.buttonStyle);

//        mImageView = new ImageView(context, attrs, defStyleAttr);
        mTextView = new TextView(context, attrs, defStyleAttr);
        mImageView = new ImageView(context);
//        mTextView = new TextView(context);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        addView(mImageView, params);
        addView(mTextView, params);

        if (mImageView.getDrawable() != null) {
            mTextView.setVisibility(GONE);
            mImageView.setVisibility(VISIBLE);
        } else {
            mTextView.setVisibility(VISIBLE);
            mImageView.setVisibility(GONE);
        }

    }
}
