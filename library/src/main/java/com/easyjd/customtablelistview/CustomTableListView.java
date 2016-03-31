package com.easyjd.customtablelistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TableLayout;

/**
 * Created by linmq on 2016/3/31.
 */
public class CustomTableListView extends TableLayout {
    private BaseAdapter mAdapter;
    private DataSetObserver dataSetObserver;

    public CustomTableListView(Context context) {
        super(context);
    }

    public CustomTableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAdapter(BaseAdapter adapter){
        if (mAdapter != null && dataSetObserver != null) {
            mAdapter.unregisterDataSetObserver(dataSetObserver);
        }
        removeAllViews();
        mAdapter = adapter;
        if (mAdapter != null) {
            dataSetObserver = new DataSetObserver() {
                @Override
                public void onChanged() {
                    super.onChanged();
                    int count = mAdapter.getCount();
                    int childCount = getChildCount();
                    for(int i = 0;i<count;i++){
                        View convertView = getChildAt(i);
                        if(convertView != null){
                            mAdapter.getView(i,convertView,CustomTableListView.this);
                        }else {
                            convertView = mAdapter.getView(i,null,CustomTableListView.this);
                            addView(convertView);
                        }
                    }
                    if(childCount > count){
                        removeViews(count,childCount-count);
                    }
                }

                @Override
                public void onInvalidated() {
                    super.onInvalidated();
                }
            };
            mAdapter.registerDataSetObserver(dataSetObserver);
            int count = mAdapter.getCount();
            for (int i = 0; i < count; i++) {
                View child = mAdapter.getView(i, null, this);
                addView(child);
            }
        }
    }
}
