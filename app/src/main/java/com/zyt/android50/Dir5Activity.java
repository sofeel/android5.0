package com.zyt.android50;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zyt.android50.ChildDetailActivity;
import com.zyt.android50.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * android 5.0目录
 * Created by user on 2017/2/15.
 */

public class Dir5Activity extends AppCompatActivity {

    private ListView rootListview, childListview;
    private ArrayList<String>rootDatas, childDatas;
    private ChildAdapter childAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dir5);

        rootDatas=new ArrayList<>();
        childDatas=new ArrayList<>();
        for (int i=0;i<8;i++){
            rootDatas.add("第"+(i+1)+"章");
        }

        rootListview = (ListView) findViewById(R.id.rootListview);
        rootListview.setAdapter(new RootAdapter());
        rootListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                childDatas.clear();
                for (int i=0;i<20;i++){
                    childDatas.add("第"+(position+1)+"章"+",第"+(i+1)+"问题");
                }
                childAdapter.notifyDataSetChanged();

            }
        });
        childListview = (ListView) findViewById(R.id.childListview);
        childAdapter = new ChildAdapter();
        childListview.setAdapter(childAdapter);
        childListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(Dir5Activity.this,ChildDetailActivity.class));
            }
        });
    }

    class RootAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return rootDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return rootDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dir5_root_item, null);
            TextView tv_chapter = (TextView) view.findViewById(R.id.tv_chapter);
            tv_chapter.setText(rootDatas.get(position));
            return view;
        }
    }

    class ChildAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return childDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return childDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dir5_root_item, null);
            TextView tv_chapter = (TextView) view.findViewById(R.id.tv_chapter);
            tv_chapter.setText(childDatas.get(position));
            return view;
        }
    }

}
