package com.example.lat3_akbif9_10116399_fahmiahmadfauzi.View;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.ActivityModel;

import java.util.List;

public interface ActivityView {
    void onLoad(List<ActivityModel> activity);

    void onSave();

    void onDelete();

    void onUpdate();
}
