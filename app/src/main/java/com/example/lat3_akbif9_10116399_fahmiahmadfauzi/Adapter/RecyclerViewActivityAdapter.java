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
import android.widget.TextView;

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.ActivityModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.R;

import java.util.List;

public class RecyclerViewActivityAdapter extends RecyclerView.Adapter<RecyclerViewActivityAdapter.ViewHolder> {

    Context context;
    private List<ActivityModel> activityy;
    private OnCallbackListener listener;

    public RecyclerViewActivityAdapter(Context context, List<ActivityModel> activityy) {
        this.activityy = activityy;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_activity, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActivityModel activity = activityy.get(position);
        holder.textViewDeskripsi.setText(activity.getDeskripsi());
        //  Glide.with(context).load(activity.getImg()).thumbnail(0.5f).transition(new DrawableTransitionOptions().crossFade()).into(holder.ViewImg);
        holder.ViewImg.setImageResource(activity.getImg());
    }

    @Override
    public int getItemCount() {
        return activityy.size();
    }

    public void setOnCallbackListener(OnCallbackListener listener) {
        this.listener = listener;
    }


    public interface OnCallbackListener {

        void onClick(ActivityModel user);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewDeskripsi;
        ImageView ViewImg;


        public ViewHolder(View inflate) {
            super(inflate);
            textViewDeskripsi = inflate.findViewById(R.id.tv_activity);
            ViewImg = inflate.findViewById(R.id.iv_activity);

        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(activityy.get(getAdapterPosition()));
            }
        }
    }
}