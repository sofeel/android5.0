package com.zyt.android50.customwidgets.ui;

/**
 * Created by user on 2017/2/23.
 */

public class SectionItem<T> {

    private String mTitle;
    private T[] mItems;

    public SectionItem(String title, T[] items) {
        if (title == null) {
            title = "";
        }
        mTitle = title;
        mItems = items;
    }

    public String getTitle() {
        return mTitle;
    }

    public T getItem(int position) {
        return mItems[position];
    }

    public int getCount() {
        return mItems == null ? 1 : 1 + mItems.length;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof SectionItem) {
            return ((SectionItem) obj).getTitle().equals(mTitle);
        }
        return false;
    }
}
