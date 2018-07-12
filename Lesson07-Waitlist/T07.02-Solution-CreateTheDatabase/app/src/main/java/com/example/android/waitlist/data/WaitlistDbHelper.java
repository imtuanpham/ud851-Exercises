package com.example.android.waitlist.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.waitlist.data.WaitlistContract.*;

// TODO COMPLETED (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    // TODO COMPLETED (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    // The database name
    private static final String DATABASE_NAME = "waitlist.db";

    // TODO COMPLETED (3) Create a static final int called DATABASE_VERSION and set it to 1
    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    // TODO COMPLETED (4) Create a Constructor that takes a context and calls the parent constructor
    // Constructor
    public WaitlistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // TODO COMPLETED (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // TODO COMPLETED (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
        // Create a table to hold waitlist data
        final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " + WaitlistEntry.TABLE_NAME + " (" +
                WaitlistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WaitlistEntry.COLUMN_GUEST_NAME + " TEXT NOT NULL, " +
                WaitlistEntry.COLUMN_PARTY_SIZE + " INTEGER NOT NULL, " +
                WaitlistEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                "); ";

        // TODO COMPLETED (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    // TODO COMPLETED (8) Override the onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // For now simply drop the table and create a new one. This means if you change the
        // DATABASE_VERSION the table will be dropped.
        // In a production app, this method might be modified to ALTER the table
        // instead of dropping it, so that existing data is not deleted.
        // TODO COMPLETED (9) Inside, execute a drop table query, and then call onCreate to re-create it
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WaitlistEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}