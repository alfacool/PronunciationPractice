package com.meio.materi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meio on 28/03/2018.
 */

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of yturl
     */
    public List<String> getyttitle() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT title FROM youtube", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public String yturl (String input){
        String Query = "SELECT url FROM youtube WHERE title ='"+input+"'";
        Cursor cursor = database.rawQuery(Query, null);
        cursor.moveToFirst();
        String Deskripsi = cursor.getString(0);
        return Deskripsi;
    }


    //list of phonetic
    public List<String> getword(String input) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT word FROM exercise3 Where mark = '"+input+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }


    public String getph (String input){
        String Query = "SELECT phonetic FROM exercise3 WHERE word ='"+input+"'";
        Cursor cursor = database.rawQuery(Query, null);
        cursor.moveToFirst();
        String ph = cursor.getString(0);
        return ph;
    }

    public String getaud (String input){
        String Query = "SELECT aud FROM exercise3 WHERE word ='"+input+"'";
        Cursor cursor = database.rawQuery(Query, null);
        cursor.moveToFirst();
        String aud = cursor.getString(0);
        return aud;
    }




}
