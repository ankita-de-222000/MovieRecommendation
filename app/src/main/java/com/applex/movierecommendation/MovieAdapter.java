package com.applex.movierecommendation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    ArrayList<DummyModel> movieList;

    public MovieAdapter(Context context, ArrayList<DummyModel> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        DummyModel model = movieList.get(position);

        holder.title.setText(model.getTitle());
        holder.year.setText(model.getDirector());
        holder.type.setText(model.getCategory());

        Picasso.get()
                .load(model.getImg())
                .into(holder.poster);



    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title, year, type;
        ImageView poster;

        public ViewHolder(@NonNull final View itemView, final Context ctx) {
            super(itemView);

            context = ctx;

            title = (TextView) itemView.findViewById(R.id.movieTitleId);
            year = (TextView) itemView.findViewById(R.id.movieReleaseId);
            type = (TextView) itemView.findViewById(R.id.movieCatId);
            poster = (ImageView) itemView.findViewById(R.id.movieImageId);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Toast.makeText(context, "Row Tapped!", Toast.LENGTH_SHORT).show();
//                    int pos = getAdapterPosition();
//                    Movie movie = movieList.get(pos);
//                    Intent intent = new Intent(context, MovieDetailsActivity.class);
//                    intent.putExtra("imdbId", movie.getImdbId());
//                    ctx.startActivity(intent);
//                }
//            });

        }

        @Override
        public void onClick(View v) {

        }
    }
}
