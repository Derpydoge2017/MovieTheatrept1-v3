package com.example.admin.movietheatrept1v3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.movietheatrept1v3.utils.MovieDetails;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

/**
 * {@link MovieAdapter} exposes a list of weather forecasts to a
 * {@link android.support.v7.widget.RecyclerView}
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    private ArrayList mMovieData;

    /*
     * An on-click handler that we've defined to make it easy for an Activity to interface with
     * our RecyclerView
     */
    private final MovieAdapterOnClickHandler mClickHandler;

    /**
     * The interface that receives onClick messages.
     */
    public interface MovieAdapterOnClickHandler {
        void onClick(String movieForDay);
    }

    // COMPLETED (4) Add a MovieAdapterOnClickHandler as a parameter to the constructor and store it in mClickHandler
    /**
     * Creates a MovieAdapter.
     *
     * @param clickHandler The on-click handler for this adapter. This single handler is called
     *                     when an item is clicked.
     */
    public MovieAdapter(MovieAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        public TextView mMovieTitle;
        public TextView mMovieReleaseDate;
        public TextView mMovieRate;
        public ImageView mMoviePosterView;

        public MovieAdapterViewHolder(View view) {
            super(view);
            mMovieTitle = (TextView) view.findViewById(R.id.tv_movie_title);
            mMovieReleaseDate = (TextView) view.findViewById(R.id.tv_movie_releaseDate);
            mMovieRate = (TextView) view.findViewById(R.id.tv_movie_Rate);
            mMoviePosterView = (ImageView) view.findViewById(R.id.tv_movie_poster);
            view.setOnClickListener(this);
        }

        /**
         * This gets called by the child views during a click.
         *
         * @param v The View that was clicked
         */
        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            MovieDetails movieDetails = (MovieDetails) mMovieData.get(adapterPosition);
            String position = movieDetails.getMovieId();
            mClickHandler.onClick(position);
        }
    }

    /**
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @param viewGroup The ViewGroup that these ViewHolders are contained within.
     * @param viewType  If your RecyclerView has more than one type of item (which ours doesn't) you
     *                  can use this viewType integer to provide a different layout. See
     *                  {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)}
     *                  for more details.
     * @return A new MovieAdapterViewHolder that holds the View for each list item
     */
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new MovieAdapterViewHolder(view);
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the movie
     * details for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param movieAdapterViewHolder The ViewHolder which should be updated to represent the
     *                                  contents of the item at the given position in the data set.
     * @param position                  The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(MovieAdapterViewHolder movieAdapterViewHolder, int position) {

        String basePictureURL = "http://image.tmdb.org/t/p/w185/";

        MovieDetails movieDetails = (MovieDetails) mMovieData.get(position);
        String title = movieDetails.getTitle();
        String releaseDate = movieDetails.getMovieReleaseDate();
        String rate = movieDetails.getMovieRate();
        String posterPath = movieDetails.getMoviePosterPath();
        String completedPosterPath = basePictureURL + posterPath;
        Picasso.with(context).load(completedPosterPath).into(movieAdapterViewHolder.mMoviePosterView);
        movieAdapterViewHolder.mMovieTitle.setText(title);
        movieAdapterViewHolder.mMovieReleaseDate.setText(releaseDate);
        movieAdapterViewHolder.mMovieRate.setText(rate);
    }

    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available in our forecast
     */
    @Override
    public int getItemCount() {
        if (null == mMovieData) return 0;
        return mMovieData.size();
    }

    /**
     * This method is used to set the movies on a MovieAdapter if we've already
     * created one. This is handy when we get new data from the web but don't want to create a
     * new MovieAdapter to display it.
     *
     * @param movieData The new weather data to be displayed.
     */
    public void setMovieData(ArrayList movieData) {
        mMovieData = movieData;
        notifyDataSetChanged();
    }

}