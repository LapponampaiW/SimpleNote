package com.su.lapponampai_w.simplenote_edited;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.AvoidXfermode;
import android.widget.Switch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * Created by apple on 4/13/16.
 */
public class MyManage {

    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase writeSQLiteDatabase,readSQLiteDatabase;



    //จะทำการ aad ข้อมูลเข้าไปใน ตาราง simplenoteTABLE
    public static final String table_main  = "simplenoteTABLE";
    public static final String column_id  = "_id";
    public static final String column_Time = "time";
    public static final String column_Content = "content";

    //ทำการอ่านค่าให้อยู่ในตัวแปรอะไรซะอย่างนึง
    private static final String[] columns = {column_id,column_Time,column_Content};
    private static final String order_By = column_Time + " DESC";


    public MyManage(Context context) {

        mySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        readSQLiteDatabase = mySQLiteOpenHelper.getReadableDatabase();
        writeSQLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();
    }

    public long addValue(int intTable,
                         String strColumn3) {
        ContentValues contentValues = new ContentValues();

        long mylong = 0;

        switch (intTable) {
            case 1:
                contentValues.put(column_Time,System.currentTimeMillis());
                contentValues.put(column_Content,strColumn3);

                mylong = writeSQLiteDatabase.insert(table_main, null, contentValues);

                break;
            default:
                break;

        }
        return mylong;
    }

    public Cursor getAllNote() {
        Cursor cursor = readSQLiteDatabase.query(table_main, columns, null, null, null, null, order_By);
        return cursor;
    }

    public StringBuilder showNote(Cursor cursor) {
        StringBuilder builder = new StringBuilder("ข้อมูลที่บันทึกไว้    : \n \n \n");

        while (cursor.moveToNext()) {

            long id = cursor.getLong(0);
            long time = cursor.getLong(1);
            String content = cursor.getString(2);

            builder.append("ลำดับ").append(id).append(" :");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String stime = simpleDateFormat.format(new Date(time));

            builder.append(stime).append("\n");
            builder.append("\t").append(content).append("\n");

        }

        return builder;
    }


}
