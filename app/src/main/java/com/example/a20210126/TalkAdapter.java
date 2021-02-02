package com.example.a20210126;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TalkAdapter extends BaseAdapter {
    private Context co;
    private int layout;
    private ArrayList<TalkVO> data;
    private LayoutInflater inflater;

    public TalkAdapter(Context co, int layout, ArrayList<TalkVO> data) {
        this.co = co;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) co.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        ImageView img_pro = convertView.findViewById(R.id.img_pro);
        img_pro.setImageResource(data.get(position).getImg());

        TextView tv_name = convertView.findViewById(R.id.tv_name);
        tv_name.setText(data.get(position).getTv_name());

        TextView tv_text = convertView.findViewById(R.id.tv_msg);
        tv_text.setText(data.get(position).getTv_text());

        TextView tv_time = convertView.findViewById(R.id.tv_time);
        tv_time.setText(data.get(position).getTv_time());

        return convertView;
    }
}
