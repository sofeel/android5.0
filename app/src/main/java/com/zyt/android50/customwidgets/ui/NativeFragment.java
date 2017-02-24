package com.zyt.android50.customwidgets.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyt.android50.R;

/**
 * Created by user on 2017/2/24.
 */

public class NativeFragment extends Fragment {


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
        tv.setBackgroundColor(Color.BLUE);
        return tv;
    }

    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        switch (transit) {
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                if (enter) {
                    return AnimatorInflater.loadAnimator(getActivity(), R.animator.fade_in);
                } else {
                    return AnimatorInflater.loadAnimator(getActivity(), R.animator.fade_in);
                }
            case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE:
                if (enter) {
                    return AnimatorInflater.loadAnimator(getActivity(), R.animator.pop_enter);
                } else {
                    return AnimatorInflater.loadAnimator(getActivity(), R.animator.pop_exit);
                }
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
            default:
                if (enter) {
                    return AnimatorInflater.loadAnimator(getActivity(), R.animator.fragment_enter);
                } else {
                    return AnimatorInflater.loadAnimator(getActivity(), R.animator.fragment_exit);
                }

        }
    }

}
