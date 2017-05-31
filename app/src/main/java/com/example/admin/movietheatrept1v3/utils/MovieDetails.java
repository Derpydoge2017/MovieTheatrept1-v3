package com.example.admin.movietheatrept1v3.utils;


import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.admin.movietheatrept1v3.MainActivity;


/**
 * Created by Admin on 20-May-17.
 */

public class MovieDetails implements Parcelable {

    private String movieId;
    private String movieOverview;
    private String moviePosterPath;

    private String movieTitle;
    private String movieReleaseDate;
    private String movieRate;

    public MovieDetails() {

    }

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


    protected MovieDetails(Parcel in) {
        movieId = in.readString();
        movieOverview = in.readString();
        moviePosterPath = in.readString();
        movieTitle = in.readString();
        movieReleaseDate = in.readString();
        movieRate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieId);
        dest.writeString(movieOverview);
        dest.writeString(moviePosterPath);
        dest.writeString(movieTitle);
        dest.writeString(movieReleaseDate);
        dest.writeString(movieRate);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MovieDetails> CREATOR = new Parcelable.Creator<MovieDetails>() {
        @Override
        public MovieDetails createFromParcel(Parcel in) {
            return new MovieDetails(in);
        }

        @Override
        public MovieDetails[] newArray(int size) {
            return new MovieDetails[size];
        }
    };
}