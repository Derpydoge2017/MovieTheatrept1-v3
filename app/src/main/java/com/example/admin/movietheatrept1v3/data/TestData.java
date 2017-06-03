package com.example.admin.movietheatrept1v3.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin.movietheatrept1v3.utils.MovieDetails;

import java.util.ArrayList;
import java.util.List;

public class TestData {



    public static void insertHATERS(SQLiteDatabase db){

        MovieDetails movieDetails = new MovieDetails();

        if(db == null) {
            return;
        }
        List<ContentValues> list = new ArrayList<>();

        ContentValues cv = new ContentValues();
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_FAVOURITE_TITLE, movieDetails.getTitle());
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_ID, movieDetails.getMovieId());
        list.add(cv);

        cv = new ContentValues();
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_FAVOURITE_TITLE,  movieDetails.getTitle());
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_ID, movieDetails.getMovieId());
        list.add(cv);

        cv = new ContentValues();
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_FAVOURITE_TITLE, movieDetails.getTitle());
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_ID, movieDetails.getMovieId());
        list.add(cv);

        cv = new ContentValues();
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_FAVOURITE_TITLE, movieDetails.getTitle());
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_ID, movieDetails.getMovieId());
        list.add(cv);

        cv = new ContentValues();
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_FAVOURITE_TITLE, movieDetails.getTitle());
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_ID, movieDetails.getMovieId());
        list.add(cv);

        //insert all guests in one transaction
        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (MovieDBContract.MovielistEntry.TABLE_NAME,null,null);
            //go through the list and add one by one
            for(ContentValues c:list){
                db.insert(MovieDBContract.MovielistEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            //no actions yet
        }
        finally
        {
            db.endTransaction();
        }

    }
}