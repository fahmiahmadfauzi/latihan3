package com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.GalleryModel;

public interface MainPresenterGallery {
    void save(GalleryModel galler);

    void update(GalleryModel galler);

    void delete(GalleryModel galler);

    void load();
}
