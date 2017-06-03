package com.example.admin.movietheatrept1v3.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.admin.movietheatrept1v3.data.MovieDBContract.*;

// COMPLETED (1) extend the SQLiteOpenHelper class
public class MovieDBHelper extends SQLiteOpenHelper {

    // COMPLETED (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    // The database name
    private static final String DATABASE_NAME = "movielist.db";

    // COMPLETED (3) Create a static final int called DATABASE_VERSION and set it to 1
    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    // COMPLETED (4) Create a Constructor that takes a context and calls the parent constructor
    // Constructor
    public MovieDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // COMPLETED (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // COMPLETED (6) Inside, create an String query called SQL_CREATE_MOVIELIST_TABLE that will create the table
        // Create a table to hold waitlist data
        final String SQL_CREATE_MOVIELIST_TABLE = "CREATE TABLE " + MovielistEntry.TABLE_NAME + " (" +
                MovielistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovielistEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL, " +
                MovielistEntry.COLUMN_MOVIE_FAVOURITE_TITLE + " TEXT NOT NULL, " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_MOVIELIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // For now simply drop the table and create a new one. This means if you change the
        // DATABASE_VERSION the table will be dropped.
        // In a production app, this method might be modified to ALTER the table
        // instead of dropping it, so that existing data is not deleted.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovielistEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}