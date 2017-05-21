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

    private String movieTitle;
    private String movieReleaseDate;
    private String movieRate;

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

    public String getTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String title) {
        this.movieTitle = title;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String releaseDate) {
        this.movieReleaseDate = releaseDate;
    }

    public String getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(String rate) {
        this.movieRate = rate;
    }

}
