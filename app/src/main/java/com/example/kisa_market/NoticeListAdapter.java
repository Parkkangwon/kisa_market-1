package com.example.kisa_market;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NoticeListAdapter extends BaseAdapter {

    private Context context;
    private List<Notice> noticeList;

    public NoticeListAdapter(Context context, List<Notice> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
    }

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Object getItem(int i) {
        return noticeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       View v= View.inflate(context,R.layout.notice,null);
       /* TextView adrText =(TextView)v.findViewById(R.id.adrText);
        TextView itemText=(TextView)v.findViewById(R.id.itemText);

        adrText.setText(noticeList.get(i).getAddress());
        itemText.setText(noticeList.get(i).getItemname());
        v.setTag(noticeList.get(i).getAddress());*/
        return v;

    }
}
