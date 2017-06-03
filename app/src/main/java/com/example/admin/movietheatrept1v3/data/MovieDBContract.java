package com.example.admin.movietheatrept1v3.data;

import android.provider.BaseColumns;

public class MovieDBContract {

    // COMPLETED (1) Create an inner class named MovielistEntry class that implements the BaseColumns interface
    public static final class MovielistEntry implements BaseColumns {
        // COMPLETED (2) Inside create a static final members for the table name and each of the db columns
        public static final String TABLE_NAME = "movielist";
        public static final String COLUMN_MOVIE_ID = "movieId";
        public static final String COLUMN_MOVIE_FAVOURITE_TITLE = "movieFavourite";
    }

}
