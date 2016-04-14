package com.su.lapponampai_w.simplenote_edited;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by apple on 4/14/16.
 */
public class MyAdaptor extends BaseAdapter {
    private Context context;
    private String[] string1,string2, string3;


    public MyAdaptor(Context context, String[] string1, String[] string2, String[] string3) {
        this.context = context;
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
    }

    @Override
    public int getCount() {
        return string1.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_my_list_view,parent,false);
        TextView textViewid = (TextView) view.findViewById(R.id.textViewid);
        textViewid.setText(string1[position]);

        TextView textViewtime = (TextView) view.findViewById(R.id.textViewtime);
        textViewtime.setText(string2[position]);

        TextView textViewcontent = (TextView) view.findViewById(R.id.textViewcontent);
        textViewcontent.setText(string3[position]);

        return view;
    }
}
