package com.samuelstudios.gainsmaker;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

/**
 * Created by Sam on 6/12/2016.
 */

public class MyDBHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="dietPlan.db";
    public static final String TABLE_FOODITEMS="foodItems";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_FOODNAME="foodName";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE "+TABLE_FOODITEMS+" ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_FOODNAME+" TEXT);";


        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP_TABLE_IF_EXISTS "+TABLE_FOODITEMS);
        onCreate(db);
    }

    //add a new row to the database
    public void addFood(FoodItems food)
    {
        ContentValues values= new ContentValues();
        values.put(COLUMN_FOODNAME,food.get_foodName());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_FOODITEMS,null,values);
        db.close();

    }

    //Delete Product from the database
    public void deleteFood(String foodName)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DElETE FROM "+TABLE_FOODITEMS+" WHERE "+COLUMN_FOODNAME+" =\""+foodName+"\";");

    }

    //print out database as a string
    public String databaseToString()
    {
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_FOODITEMS + " WHERE 1";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        int n=0;
        while(!c.isAfterLast())
        {
            if (c.getString(c.getColumnIndex("foodName")) != null)
                     {
                n++;
                dbString +=n+": "+ c.getString(c.getColumnIndex("foodName"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;

    }



}
