package com.easyjd.customtablelistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;

import java.util.List;
import com.easyjd.customtablelistview_sample.R;

/**
 * Created by linmq on 2016/3/31.
 */
public class SimpleAdapter<T extends SimpleAdapter.ViewTypeInterface> extends BaseAdapter {
    List<T> mData;

    public SimpleAdapter(List<T> mData) {
        this.mData = mData;
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getType().ordinal();
    }

    @Override
    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public ViewTypeInterface getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewTypeInterface item = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(item.getType().getLayoutRes(),null);
        }
        TableLayout.LayoutParams params = new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        convertView.setLayoutParams(params);
        return convertView;
    }

    public interface ViewTypeInterface{
        ViewType getType();
    }
    public enum ViewType{
        TYPE1(R.layout.sample_type1),
        TYPE2(R.layout.sample_type2),
        TYPE3(R.layout.sample_type3);
        private int layoutRes;
        ViewType(int layoutRes) {
            this.layoutRes = layoutRes;
        }

        public int getLayoutRes() {
            return layoutRes;
        }
    }
}
