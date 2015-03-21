package com.example.marcelba.notes_p8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.sql.SQLClientInfoException;

/**
 * Created by marcelba on 17/03/2015.
 */
public class DBProxy extends SQLiteOpenHelper {

    public static final String databaseName = "MyDatabase";
    public static final int databaseVersion = 1;
    public static final String id = BaseColumns._ID;
    public static final String databaseTitle = "title";
    public static final String databaseNote = "note";

    public DBProxy(Context context) {
        super(context,databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE "+databaseName+"("+id+" INTEGER PRIMARY KEY,"+databaseTitle+" TEXT, "+databaseNote+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addNote(String title, String note){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.putNull(id);
        values.put(databaseTitle, title);
        values.put(databaseNote, note);
        db.insert(databaseName, null, values);
    }

       public void updateNote(Long id, String title, String body)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(databaseTitle, title);
        values.put(databaseNote, body);

        String selection = id + " LIKE ?";
        String[] selectionArgs = { String.valueOf(id) };
        db.update(databaseName,values,selection,selectionArgs);
    }

    public Cursor getAllNotes(){
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = new String[]{id, databaseTitle, databaseNote};
        return db.query(databaseName,columns, null, null, null, null, null);
    }
}
