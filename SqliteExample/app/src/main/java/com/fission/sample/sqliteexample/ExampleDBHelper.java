package com.fission.sample.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class ExampleDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME="SQLiteExample.db";
    public static final String PERSON_TABLE_NAME = "person";
    public static final String PERSON_COLUMN_ID = "_id";
    public static final String PERSON_COLUMN_NAME = "name";
    public static final String PERSON_COLUMN_BRANCH = "branch";
    public static final String PERSON_COLUMN_PHNO = "phno";
    ExampleDBHelper(Context context) {
            super(context,DATABASE_NAME, null, DATABASE_VERSION);
        }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+PERSON_TABLE_NAME + "("+PERSON_COLUMN_ID+" INTEGER, "+PERSON_COLUMN_NAME+" TEXT PRIMARY KEY, "+PERSON_COLUMN_PHNO+" TEXT, "+ PERSON_COLUMN_BRANCH+" TEXT)");

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    db.execSQL("DROP TABLE IF EXISTS " + PERSON_TABLE_NAME);
    onCreate(db);
    }
    public boolean insertPerson(String name,String phno,String branch){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PERSON_COLUMN_NAME,name);
        contentValues.put(PERSON_COLUMN_PHNO,phno);
        contentValues.put(PERSON_COLUMN_BRANCH,branch);
        db.insert(PERSON_TABLE_NAME, null, contentValues);
        return  true;
    }
   /* public boolean updatePerson(String name, String phno, String branch) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PERSON_COLUMN_NAME, name);
        contentValues.put(PERSON_COLUMN_PHNO, phno);
        contentValues.put(PERSON_COLUMN_BRANCH,branch);
        db.update(PERSON_TABLE_NAME, contentValues, PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) } );
        return true;
    }*/
    public Cursor showOne(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        //String[] requiredColumns = {PERSON_COLUMN_ID,PERSON_COLUMN_NAME,PERSON_COLUMN_BRANCH,PERSON_COLUMN_PHNO};
        Cursor res =  db.rawQuery( "select * from "+PERSON_TABLE_NAME+ " where name = '" + name+"'", null );
        res.getCount();
        return res;
    }
    public Cursor showAll(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+PERSON_TABLE_NAME,null);


        return res;
    }
    public void deleteContact(String name){
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("delete from " +  PERSON_TABLE_NAME+  " where name = '"+ name +"'",null);

        Log.e("A", "res = "+res.getCount());

        //return  db.delete(PERSON_TABLE_NAME,PERSON_COLUMN_ID +)
    }
}