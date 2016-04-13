package com.su.lapponampai_w.simplenote_edited;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by apple on 4/12/16.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SimpleNote.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_SIMPLENOTE_MAIN = "create table simplenoteTABLE" +
            "(_id integer primary key, time text, content text);";


    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    } //Constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SIMPLENOTE_MAIN);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
} //Main Class
