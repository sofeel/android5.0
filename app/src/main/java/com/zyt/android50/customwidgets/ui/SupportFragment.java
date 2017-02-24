package com.zyt.android50.customwidgets.ui;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.zyt.android50.R;
/**
 * Created by user on 2017/2/24.
 */

public class SupportFragment extends android.support.v4.app.Fragment {


    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment", "fragment");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        tv.setText("fragment");
        tv.setBackgroundColor(Color.RED);
        return tv;
    }

    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        switch (transit) {
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                if (enter) {
                    return AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
                } else {
                    return AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
                }
            case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE:
                if (enter) {
                    return AnimationUtils.loadAnimation(getActivity(), R.anim.close_enter);
                } else {
                    return AnimationUtils.loadAnimation(getActivity(), R.anim.close_exit);
                }
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
            default:
                if (enter) {
                    return AnimationUtils.loadAnimation(getActivity(), R.anim.open_enter);
                } else {
                    return AnimationUtils.loadAnimation(getActivity(), R.anim.open_exit);
                }

        }
    }

}
