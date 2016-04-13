package com.su.lapponampai_w.simplenote_edited;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyManage myManage;
    Button button,buttonDelete;
    EditText editText;
    TextView textView;

    private static final String DATABASE_NAME = "SimpleNote.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //เชื่อมต่อ
        myManage = new MyManage(this);

        //Bindwidget
        bindwidget();

        //showNote ที่เก็บไว้
        showNote();



        //deleteAllData ลบแต่ข้อมูลอย่างเดียวไม่ลบ Database
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAllData();
                showNote();
                Toast t = Toast.makeText(MainActivity.this, "ลบข้อมูลสำเร็จ", Toast.LENGTH_LONG);
                t.show();
            }
        });



       /* Cursor cursor = myManage.getAllNote();
       StringBuilder sB =  myManage.showNote(cursor);
        textView.setText(sB); */


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myManage.addValue(1, editText.getText().toString());

                Toast t = Toast.makeText(MainActivity.this, "เพิ่มข้อความเรียบร้อยแล้ว", Toast.LENGTH_LONG);
                t.show();

                showNote();
                editText.setText(null);
            }
        });


    }

    //ลบแต่ข้อมูลอย่างเดียวไม่ลบ Database ทำไมถึงทำในหน้านี้ได้แต่ทำใน MyManage ไม่ได้
    //==> ต้องทำใน class แม่ (extends) AppCompatActivity เท่านั้น
    private void deleteAllData() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_APPEND, null);
        sqLiteDatabase.delete("simplenoteTABLE", null, null);

    }

    private void showNote() {
        Cursor cursor = myManage.getAllNote();
        StringBuilder sB =  myManage.showNote(cursor);
        textView.setText(sB);

    }

    private void bindwidget() {
        button = (Button) findViewById(R.id.save_button);
        editText = (EditText) findViewById(R.id.new_text);
        textView = (TextView) findViewById(R.id.all_text);
        buttonDelete = (Button) findViewById(R.id.button_Delete);

    }
}
