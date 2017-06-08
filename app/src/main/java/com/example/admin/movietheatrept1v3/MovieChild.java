package com.example.admin.movietheatrept1v3;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.movietheatrept1v3.data.MovieDBContract;
import com.example.admin.movietheatrept1v3.data.MovieDBHelper;
import com.example.admin.movietheatrept1v3.utils.MovieDetails;
import com.squareup.picasso.Picasso;

public class MovieChild extends AppCompatActivity {

    private static final String SHARE = " #MovieApp";

    String basePictureURL = "http://image.tmdb.org/t/p/w185/";

    private MovieDetails mMovie;

    private TextView mMovieTitleDisplay;
    private TextView mMovieOverviewDisplay;
    private TextView mMovieRateDisplay;
    private TextView mMovieReleaseDateDisplay;
    private ImageView mMovieImageDisplay;

    private FloatingActionButton favouriteButton;

    private SQLiteDatabase mDB;

    private Context context;

    public MovieChild(Context clickHandler) {
        context = clickHandler;
    }

    public MovieChild() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        MovieDBHelper dbHelper = new MovieDBHelper(this);

        mDB = dbHelper.getWritableDatabase();

        mMovieTitleDisplay = (TextView) findViewById(R.id.tv_detail_title);
        mMovieOverviewDisplay = (TextView) findViewById(R.id.tv_detail_overview);
        mMovieRateDisplay = (TextView) findViewById(R.id.tv_detail_rate);
        mMovieImageDisplay = (ImageView) findViewById(R.id.tv_detail_poster);
        mMovieReleaseDateDisplay = (TextView) findViewById(R.id.tv_detail_release);

        favouriteButton = (FloatingActionButton) findViewById(R.id.favouriteB);


        mMovie = getIntent().getParcelableExtra("android.intent.extra.TITLE");

        final String title = mMovie.getTitle();

        mMovieTitleDisplay.setText(title);

        String overview = mMovie.getMovieOverview();
        mMovieOverviewDisplay.setText(overview);

        String rate = mMovie.getMovieRate();
        mMovieRateDisplay.setText(rate);

        String releaseDate = mMovie.getMovieReleaseDate();
        mMovieReleaseDateDisplay.setText(releaseDate);

        String posterPath = mMovie.getMoviePosterPath();
        String completedPosterPath = basePictureURL + posterPath;
        Picasso.with(context).load(completedPosterPath).into(mMovieImageDisplay);

        final String movieId = mMovie.getMovieId();

        favouriteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                addNewFavourite(title, movieId);

                Toast.makeText(MovieChild.this,
                        "Added " + title + " to the list of movies", Toast.LENGTH_SHORT).show();

            }

        });

    }


    private long addNewFavourite(String movieTitle, String movieId) {
        ContentValues cv = new ContentValues();
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_FAVOURITE_TITLE, movieTitle);
        cv.put(MovieDBContract.MovielistEntry.COLUMN_MOVIE_ID, movieId);
        return mDB.insert(MovieDBContract.MovielistEntry.TABLE_NAME, null, cv);
    }

    private boolean removeFavourite(String id) {
        return mDB.delete(MovieDBContract.MovielistEntry.TABLE_NAME, MovieDBContract.MovielistEntry._ID + "=" + id, null) > 0;
    }


}