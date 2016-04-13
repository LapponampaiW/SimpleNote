package com.su.lapponampai_w.simplenote_edited;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Switch;

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


}
