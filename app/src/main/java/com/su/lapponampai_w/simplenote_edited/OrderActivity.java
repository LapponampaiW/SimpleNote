package com.su.lapponampai_w.simplenote_edited;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    TextView textViewid, textViewtime, textViewcontent;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        bindWidget();


        createListView();


    }

    private void createListView() {

        MyManage myManage = new MyManage(this);
        String[] text1 = myManage.readallData(0);
        String[] text2 = myManage.readallData(1);
        String[] text3 = myManage.readallData(2);

        MyAdaptor myAdaptor = new MyAdaptor(OrderActivity.this, text1, text2, text3);
        listView.setAdapter(myAdaptor);

    }

    private void bindWidget() {
        textViewid = (TextView) findViewById(R.id.textViewid);
        textViewtime = (TextView) findViewById(R.id.textViewtime);
        textViewcontent = (TextView) findViewById(R.id.textViewcontent);
        listView = (ListView) findViewById(R.id.listView);
    }
}
