package com.zyt.android50.customwidgets.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zyt.android50.R;

/**
 * 构建多个布局文件
 * Created by user on 2017/2/22.
 */

public class Activity1_8 extends AppCompatActivity implements View.OnClickListener {


    private ListView list;
    private LinearLayout empty;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_1_8);
        list = (ListView) findViewById(R.id.mylist);
        empty = (LinearLayout) findViewById(R.id.myempty);
        list.setEmptyView(empty);
        SimpleSectionsAdapter<String> adapter = new SimpleSectionsAdapter<String>(
                list,
                R.layout.list_header,
                android.R.layout.simple_list_item_1
        )
        {
            @Override
            public void onSectionItemClick(String item) {
                Log.e("tag","onSectionItemClick");
            }
        };
        adapter.addSection("1111",new String[]{"qwqwq","wew","sasa"});
        adapter.addSection("222",new String[]{"qwqsaswq","wesdsdw","sds"});
        list.setAdapter(adapter);


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
