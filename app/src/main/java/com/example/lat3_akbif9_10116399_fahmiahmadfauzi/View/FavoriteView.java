package com.example.lat3_akbif9_10116399_fahmiahmadfauzi.View;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.FavoriteModel;

import java.util.List;

public interface FavoriteView {
    void onLoad(List<FavoriteModel> favorite);

    void onSave();

    void onDelete();

    void onUpdate();
}

