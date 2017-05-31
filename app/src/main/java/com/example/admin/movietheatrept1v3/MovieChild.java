package com.example.admin.movietheatrept1v3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

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

        mMovieTitleDisplay = (TextView) findViewById(R.id.tv_detail_title);
        mMovieOverviewDisplay = (TextView) findViewById(R.id.tv_detail_overview);
        mMovieRateDisplay = (TextView) findViewById(R.id.tv_detail_rate);
        mMovieImageDisplay = (ImageView) findViewById(R.id.tv_detail_poster);
        mMovieReleaseDateDisplay = (TextView) findViewById(R.id.tv_detail_release);

        mMovie = getIntent().getParcelableExtra("android.intent.extra.TITLE");

        String title = mMovie.getTitle();

        mMovieTitleDisplay.setText(title);

        String overview = mMovie.getMovieOverview();

        mMovieOverviewDisplay.setText(overview);

        String rate = mMovie.getMovieRate();

        mMovieRateDisplay.setText(rate);

        String posterPath = mMovie.getMoviePosterPath();

        String completedPosterPath = basePictureURL + posterPath;

        String releaseDate = mMovie.getMovieReleaseDate();

        mMovieReleaseDateDisplay.setText(releaseDate);

        Picasso.with(context).load(completedPosterPath).into(mMovieImageDisplay);

    }
}