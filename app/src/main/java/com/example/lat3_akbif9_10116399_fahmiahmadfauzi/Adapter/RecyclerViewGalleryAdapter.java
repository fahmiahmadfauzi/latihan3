package com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Adapter;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.GalleryModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.R;

import java.util.List;

public class RecyclerViewGalleryAdapter extends RecyclerView.Adapter<RecyclerViewGalleryAdapter.ViewHolder> {

    Context context;
    private List<GalleryModel> gallery;
    private RecyclerViewGalleryAdapter.OnCallbackListener listener;

    public RecyclerViewGalleryAdapter(Context context, List<GalleryModel> gallery) {
        this.gallery = gallery;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewGalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewGalleryAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_gallery, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewGalleryAdapter.ViewHolder holder, int position) {
        GalleryModel galler = gallery.get(position);
        //  Glide.with(context).load(activity.getImg()).thumbnail(0.5f).transition(new DrawableTransitionOptions().crossFade()).into(holder.ViewImg);
        holder.ViewImg.setImageResource(galler.getImg());
    }

    @Override
    public int getItemCount() {
        return gallery.size();
    }

    public void setOnCallbackListener(RecyclerViewGalleryAdapter.OnCallbackListener listener) {
        this.listener = listener;
    }


    public interface OnCallbackListener {

        void onClick(GalleryModel user);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ViewImg;


        public ViewHolder(View inflate) {
            super(inflate);
            ViewImg = inflate.findViewById(R.id.iv_gallery);

        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(gallery.get(getAdapterPosition()));
            }
        }
    }
}
