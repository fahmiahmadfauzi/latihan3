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
import android.widget.TextView;

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.FriendsModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewFriendsAdapter extends RecyclerView.Adapter<RecyclerViewFriendsAdapter.ViewHolder> {

    Context context;
    private List<FriendsModel> friends;
    private RecyclerViewFriendsAdapter.OnCallbackListener listener;

    public RecyclerViewFriendsAdapter(Context context, List<FriendsModel> friends) {
        this.friends = friends;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewFriendsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewFriendsAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_friends, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewFriendsAdapter.ViewHolder holder, int position) {
        FriendsModel friend = friends.get(position);
        holder.textViewNama.setText(friend.getNama());
        //  Glide.with(context).load(activity.getImg()).thumbnail(0.5f).transition(new DrawableTransitionOptions().crossFade()).into(holder.ViewImg);
        holder.ViewImg.setImageResource(friend.getImg());
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public void setOnCallbackListener(RecyclerViewFriendsAdapter.OnCallbackListener listener) {
        this.listener = listener;
    }


    public interface OnCallbackListener {

        void onClick(FriendsModel user);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewNama;
        CircleImageView ViewImg;


        public ViewHolder(View inflate) {
            super(inflate);
            textViewNama = inflate.findViewById(R.id.nm_friends);
            ViewImg = inflate.findViewById(R.id.iv_firends);

        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(friends.get(getAdapterPosition()));
            }
        }
    }
}