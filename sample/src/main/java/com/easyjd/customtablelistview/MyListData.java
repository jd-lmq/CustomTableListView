package com.easyjd.customtablelistview;

/**
 * Created by linmq on 2016/3/31.
 */
public class MyListData implements SimpleAdapter.ViewTypeInterface {
    private SimpleAdapter.ViewType viewType;

    public MyListData(SimpleAdapter.ViewType viewType) {
        this.viewType = viewType;
    }

    @Override
    public SimpleAdapter.ViewType getType() {
        return viewType;
    }
}
