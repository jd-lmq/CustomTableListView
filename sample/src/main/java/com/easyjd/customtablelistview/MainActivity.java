package com.easyjd.customtablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.easyjd.customtablelistview_sample.R;

public class MainActivity extends AppCompatActivity {

    private CustomTableListView tableList;
    private SimpleAdapter mAdapter;
    private List<MyListData> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableList = (CustomTableListView)findViewById(R.id.custom_list);
        mData = new ArrayList<>();
        mAdapter = new SimpleAdapter(mData);
        tableList.setAdapter(mAdapter);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i = random.nextInt(3);
                MyListData data = new MyListData(SimpleAdapter.ViewType.values()[i]);
                mData.add(data);
                mAdapter.notifyDataSetChanged();
            }
        });
        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.clear();
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
