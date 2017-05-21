package com.example.admin.movietheatrept1v3.utils;

import android.content.Context;

import com.example.admin.movietheatrept1v3.MainActivity;


/**
 * Created by Admin on 20-May-17.
 */

public class MovieDetails {

    private String movieId;
    private String movieOverview;
    private String moviePosterPath;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String id) {
        this.movieId = id;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String overview) {
        this.movieOverview = overview;
    }

    public String getMoviePosterPath() {
        return moviePosterPath;
    }

    public void setMoviePosterPath(String poster_path) {
        this.moviePosterPath = poster_path;
    }

}
