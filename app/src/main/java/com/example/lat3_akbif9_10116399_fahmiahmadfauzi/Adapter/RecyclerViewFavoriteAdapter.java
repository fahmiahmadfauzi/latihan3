package com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Adapter;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.FavoriteModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.R;

import java.util.List;

public class RecyclerViewFavoriteAdapter extends RecyclerView.Adapter<RecyclerViewFavoriteAdapter.ViewHolder> {

    Context context;
    private List<FavoriteModel> favorite;
    private RecyclerViewFavoriteAdapter.OnCallbackListener listener;

    public RecyclerViewFavoriteAdapter(Context context, List<FavoriteModel> favorite) {
        this.favorite = favorite;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewFavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewFavoriteAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_favorite, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewFavoriteAdapter.ViewHolder holder, int position) {
        FavoriteModel fav = favorite.get(position);
        holder.desk.setText(fav.getDeskripsi());
        //  Glide.with(context).load(activity.getImg()).thumbnail(0.5f).transition(new DrawableTransitionOptions().crossFade()).into(holder.ViewImg);
        holder.ViewVi.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" + fav.getVideo()));
    }

    @Override
    public int getItemCount() {
        return favorite.size();
    }

    public void setOnCallbackListener(RecyclerViewFavoriteAdapter.OnCallbackListener listener) {
        this.listener = listener;
    }


    public interface OnCallbackListener {

        void onClick(FavoriteModel user);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        VideoView ViewVi;
        TextView desk;


        public ViewHolder(View inflate) {
            super(inflate);
            desk = inflate.findViewById(R.id.tv_favorite);
            ViewVi = inflate.findViewById(R.id.vv_favorite);

        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(favorite.get(getAdapterPosition()));
            }
        }
    }
}
