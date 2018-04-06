package com.example.fuffy.ee461lhomework4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SearchHistoryDatabaseHelper extends SQLiteOpenHelper{

    public SearchHistoryDatabaseHelper(Context context){
        super(context, "searchDB", null, 1 );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        initSearchHistory(db);

    }

    private void initSearchHistory(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SEARCH_HISTORY (" +
                "_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "SEARCH_NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
