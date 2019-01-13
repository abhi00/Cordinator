package com.aptron.cordinator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "userdb.db";
    private static final String TABLE = "user_table";
    private static final String C_ID = "c_id";
    private static final String C_USER = "c_user";
    private static final String C_PASS = "c_pass";
    private static final String C_TYPE = "c_type";
    private static final int DB_VERSION = 4;

    private static final String query = "CREATE TABLE "
            +TABLE+" ( "+C_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +C_USER+"  TEXT,"
            +C_PASS+" TEXT,"
            +C_TYPE+" TEXT);";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE;




    public DbHelper(Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public long insertData(String email ,String pass , String type)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(C_USER, email);
        values.put(C_PASS,pass);
        values.put(C_TYPE,type);
        long newRowId = db.insert(TABLE, null, values);
        db.close();

        return newRowId;

    }
    public boolean authUser(String email ,String pass , String type)
    {
        boolean status = false;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from "+TABLE+" where "
                +C_USER+" = "+"'"+email+"'"+" and "
                +C_PASS+" = "+"'"+pass+"'"+" and "
                +C_TYPE+" = "+"'"+type+"'";
        Cursor cursor =db.rawQuery(query,null);
        if(cursor.getCount()>0)
        {
            status = true;
        }


        cursor.close();
        db.close();

        return status;

    }
}
