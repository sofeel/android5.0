package com.zyt.android50.customwidgets.ui;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zyt.android50.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义多个节适配器
 * Created by user on 2017/2/23.
 */

public abstract class SimpleSectionsAdapter<T> extends BaseAdapter implements AdapterView.OnItemClickListener {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private LayoutInflater mLayoutInflater;
    private int mHeaderResource;
    private int mItemResource;

    private List<SectionItem<T>> mSections;
    private SparseArray<SectionItem> mKeyedSections;

    public SimpleSectionsAdapter(ListView parent, int headerResId, int itemResId) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        mHeaderResource = headerResId;
        mItemResource = itemResId;

        mSections = new ArrayList<>();
        mKeyedSections = new SparseArray<>();
        parent.setOnItemClickListener(this);
    }

    //添加带标题的节
    public void addSection(String title, T[] items) {
        SectionItem<T> selctionItem = new SectionItem<T>(title, items);
        int currentIndex = mSections.indexOf(selctionItem);
        if (currentIndex >= 0) {
            mSections.remove(selctionItem);
            mSections.add(currentIndex, selctionItem);
        } else {
            mSections.add(selctionItem);
        }

        recordSections();
        notifyDataSetChanged();
    }

    public void recordSections() {
        mKeyedSections.clear();
        int startPoint = 0;
        for (SectionItem<T> item : mSections) {
            mKeyedSections.put(startPoint, item);
            startPoint += item.getCount();
        }
    }


    @Override
    public int getCount() {
        int count = 0;
        for (SectionItem<T> item : mSections) {
            count += item.getCount();
        }
        return count;
    }


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderAtPosition(position)) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    private boolean isHeaderAtPosition(int position) {
        for (int i = 0; i < mKeyedSections.size(); i++) {
            if (position == mKeyedSections.keyAt(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getItem(int position) {
        return findSectionItemAtPosition(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return !isHeaderAtPosition(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                return getHeaderView(position, convertView, parent);
            case TYPE_ITEM:
                return getItemView(position, convertView, parent);
            default:
                return convertView;
        }

    }


    private View getHeaderView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(mHeaderResource, parent, false);
        }

        SectionItem<T> item = mKeyedSections.get(position);
        TextView text = (TextView) convertView.findViewById(R.id.text1);
        text.setText(item.getTitle());

        return convertView;
    }

    private View getItemView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(mItemResource, parent, false);
        }

        T item = findSectionItemAtPosition(position);
        TextView text = (TextView) convertView.findViewById(android.R.id.text1);
        text.setText(item.toString());

        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        T item = findSectionItemAtPosition(position);
        if (item != null) {
            onSectionItemClick(item);
        }

    }

    public abstract void onSectionItemClick(T item);


    private T findSectionItemAtPosition(int position) {
        int firstIndex, lastIndex;
        for (int i = 0; i < mKeyedSections.size(); i++) {
            firstIndex = mKeyedSections.keyAt(i);
            lastIndex = firstIndex + mKeyedSections.valueAt(i).getCount();
            if (position >= firstIndex && position < lastIndex) {
                int sectionPoint = position - firstIndex - 1;
                return (T) mKeyedSections.valueAt(i).getItem(sectionPoint);
            }
        }
        return null;
    }
}
