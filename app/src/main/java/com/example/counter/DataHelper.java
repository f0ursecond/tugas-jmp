package com.example.counter;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public  class DataHelper extends  SQLiteOpenHelper {

    private static final String DATABASE_NAME = "person.db";
    private static final int DATABASE_VERSION = 1;

    public  DataHelper(Context context) {
        super(context, DATABASE_NAME , null ,DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        String sql = "create table person(nama text null, alamat text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO person (nama,alamat) VALUES ('Darsiwan','Indramayu');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
