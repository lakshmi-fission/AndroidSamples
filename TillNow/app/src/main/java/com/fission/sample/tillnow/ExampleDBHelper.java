package com.fission.sample.tillnow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.w3c.dom.Text;

/**
 * Created by lakshmi on 6/6/16.
 */
public class ExampleDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME="SQLiteExample.db";
    public static final String TABLE_NAME="LOGIN";
    public static final String COLUM_USERNAME="userName";
    public static final String COLUM_PASSWORD="password";
    ExampleDBHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "("+COLUM_USERNAME + " TEXT PRIMARY KEY, " +COLUM_PASSWORD + " TEXT)");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String userName,String passWord){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("userName",userName);
        values.put("password",passWord);
        long error = db.insert("LOGIN", null, values);
        if(error == -1){
            return false;
        }
        else{
            return true;
        }

    }
    public Cursor getSingleEntry(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME+ " where userName = '" + name+"'", null );
        Log.e("A","res count="+res.getCount());
        return res;
    }
}
