package com.example.vallimaielc.smoothiesprototype;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class NewUsers extends SQLiteOpenHelper {
    private static final String dbName = "app9";
    private static final String tableName = "newCust";
    private static final String col = "phone";
    private static final String col1 = "name";
    private static final String col2 = "password";
    static String ph;

    String createTable = "CREATE TABLE " + tableName + " (" +
            col + " INTEGER PRIMARY KEY," +
            col1 + " TEXT," +
            col2 + " TEXT)";
    private static final String tableOrders = "foodiesss";
    private static final String column = "orderid";
    public static final String column1 = "Userphone";
    private static final String column2 = "smoothie";
    private static final String column3 = "servings";
    private static final String column4 = "amount";

    String CREATE = "create table "
            + tableOrders + " ("
            + column + " integer primary key autoincrement,"
            + column1 + " integer,"
            + column2 + " text,"
            + column3 + " text,"
            + column4 + " text,"
            + " FOREIGN KEY (" + column1 + ") REFERENCES " + tableName + "(" + col + "));";


    public NewUsers(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
        Log.d("createTable", "%%%%%%%%%%%%%%%%%%$$$$$$$$$$$$$$$$$$$$");
        db.execSQL(CREATE);
        Log.d("createTable", "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUsers(String phone, String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col, phone);
        contentValues.put(col1, name);
        contentValues.put(col2, password);
        Log.d(name, password);
        long result = db.insert(tableName, null, contentValues);
        Log.d("hyyy", "########################3");
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }

    public boolean userexists(String number, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM newCust WHERE phone= ? and password=?", new String[]{number, pass});
        if (c.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean orders(String phone, String smoothie_name, String serves_count, String order_total) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column1, phone);
        contentValues.put(column2, smoothie_name);
        contentValues.put(column3, serves_count);
        contentValues.put(column4, order_total);
        Log.d(serves_count, order_total);
        long result = db.insert(tableOrders, null, contentValues);
        Log.d("orders inserted", "########################3");
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }

   public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor data = db.rawQuery("SELECT * FROM foodiesss WHERE Userphone= ? ", new String[]{SignIn.mobileno});
       Cursor data=db.rawQuery("select * from foodiesss where Userphone="+SignIn.mobileno + " order by orderid desc",null);
        Log.d("Data fetched", "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        return data;
    }
    public Cursor getDataFirst() {
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor data= db.query(tableOrders, null, null, null, null, null, column + " DESC");
        Cursor data=db.rawQuery("select * from foodiesss where Userphone="+SignIn.mobileno + " order by orderid desc",null);
        Log.d("Desc order by", "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        ph = SignIn.mobileno;
        Log.d("db phone",NewUsers.ph);
        return data;
    }







}
