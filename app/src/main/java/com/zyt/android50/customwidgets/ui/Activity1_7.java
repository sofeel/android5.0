package com.zyt.android50.customwidgets.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zyt.android50.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * 构建多个布局文件
 * Created by user on 2017/2/22.
 */

public class Activity1_7 extends AppCompatActivity implements View.OnClickListener {


    private ListView list;
    private LinearLayout empty;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_7);
        list = (ListView) findViewById(R.id.mylist);
        empty = (LinearLayout) findViewById(R.id.myempty);
        list.setEmptyView(empty);
        CustomAdapter adapter = new CustomAdapter(this,
                R.layout.custom_row,
                R.id.line1,
                new String[]{"Bill", "Tom", "Sally", "Jenny "});
        list.setAdapter(adapter);


    }


    private static class CustomAdapter extends ArrayAdapter<String> {

        public CustomAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                row = LayoutInflater.from(getContext()).inflate(R.layout.custom_row, parent, false);
            }
            String item = getItem(position);
            ImageView left = (ImageView) row.findViewById(R.id.leftImage);
            ImageView right = (ImageView) row.findViewById(R.id.rightImage);
            TextView text = (TextView) row.findViewById(R.id.line1);

            left.setImageResource(R.drawable.head);
            right.setImageResource(R.drawable.tails);
            text.setText(item);

            return row;
        }
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
