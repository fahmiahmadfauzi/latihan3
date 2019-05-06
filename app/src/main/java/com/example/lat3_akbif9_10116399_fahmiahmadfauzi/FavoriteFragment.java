package com.example.lat3_akbif9_10116399_fahmiahmadfauzi;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Adapter.RecyclerViewFavoriteAdapter;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.FavoriteModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter.MainPresenterFavorite;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter.MainPresenterImplFavorite;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.View.FavoriteView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment implements FavoriteView {
    private RecyclerView recyclerView;
    private RecyclerViewFavoriteAdapter adapter;
    private List<FavoriteModel> favoriteList = new ArrayList<>();
    private MainPresenterFavorite presenter;


    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View favoritefragment = inflater.inflate(R.layout.fragment_favorite, container, false);
        presenter = new MainPresenterImplFavorite(this);


        recyclerView = favoritefragment.findViewById(R.id.recyclerview_favorite);

        adapter = new RecyclerViewFavoriteAdapter(getActivity(), favoriteList);

        recyclerView.setAdapter(adapter);
        presenter.load();


        return favoritefragment;

    }

    @Override
    public void onLoad(List<FavoriteModel> favorite) {
        favoriteList.clear();
        favoriteList.addAll(favorite);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onSave() {

    }

    @Override
    public void onDelete() {

    }

    @Override
    public void onUpdate() {

    }
}
