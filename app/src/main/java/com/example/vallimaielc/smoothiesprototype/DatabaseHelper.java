/*package com.example.vallimaielc.smoothiesprototype;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String dbName = "myApp";
    private static final String tableName="juice";
    private static final String col="id";
    private static final String col1="smoothie";
    private static final String col2="servings";
    private static final String col3="amount";
    String createTable = "CREATE TABLE " + tableName + " (" +
            col + " INTEGER PRIMARY KEY," +
            col1 + " TEXT," +
            col2 + " TEXT," +
            col3 + " TEXT)";
    public DatabaseHelper(Context context) {
        super(context, dbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createTable);
        Log.d("createTable","$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addData(String smoothie_name,String serves_count,String order_total)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1,smoothie_name);
        contentValues.put(col2,serves_count);
        contentValues.put(col3,order_total);
        Log.d(serves_count,order_total);
        long result = db.insert(tableName,null,contentValues);
        Log.d("hyyy","########################3");
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }


    }
    public Cursor getData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.query(tableName, null, null, null, null, null, col+" DESC");
        Log.d("hyyy","@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return data;
    }


}*/
