package com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.ActivityModel;

public interface MainPresenterActivity {
    void save(ActivityModel activity);

    void update(ActivityModel activity);

    void delete(ActivityModel activity);

    void load();

}
