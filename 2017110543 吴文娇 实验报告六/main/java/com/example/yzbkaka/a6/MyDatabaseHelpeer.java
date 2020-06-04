package com.example.yzbkaka.a6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yzbkaka on 20-4-17.
 */

public class MyDatabaseHelpeer extends SQLiteOpenHelper {

    public static final String CREATE_PERSON = "create table Person("
            + "_id integer primary key autoincrement,"
            + "name text,"
            + "age integer)";

    private Context context;

    public MyDatabaseHelpeer(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_PERSON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
