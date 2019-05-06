package com.example.lat3_akbif9_10116399_fahmiahmadfauzi;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Adapter.RecyclerViewGalleryAdapter;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.GalleryModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter.MainPresenterGallery;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter.MainPresenterImplGallery;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.View.GalleryView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements GalleryView {
    private RecyclerView recyclerView;
    private RecyclerViewGalleryAdapter adapter;
    private List<GalleryModel> galleryList = new ArrayList<>();
    private MainPresenterGallery presenter;


    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View galleryfragment = inflater.inflate(R.layout.fragment_gallery, container, false);
        presenter = new MainPresenterImplGallery(this);


        recyclerView = galleryfragment.findViewById(R.id.recyclerview_gallery);

        adapter = new RecyclerViewGalleryAdapter(getActivity(), galleryList);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);
        presenter.load();


        return galleryfragment;
    }

    @Override
    public void onLoad(List<GalleryModel> gallery) {
        galleryList.clear();
        galleryList.addAll(gallery);

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
