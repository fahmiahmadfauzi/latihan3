package com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.ActivityModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.R;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.View.ActivityView;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImplActivity implements MainPresenterActivity {

    private ActivityView activityView;

    private List<ActivityModel> activityy = new ArrayList<>();
    private int no = 4;

    public MainPresenterImplActivity(ActivityView activityView) {
        this.activityView = activityView;
        setData();
    }

    private void setData() {
        ActivityModel activity = new ActivityModel();
        activity.setId(1);
        activity.setDeskripsi("ini aktivitas ku sebelum puasa gaes");
        activity.setImg(R.drawable.chicken);
        activityy.add(activity);

        ActivityModel activity1 = new ActivityModel();
        activity1.setId(2);
        activity1.setDeskripsi("ngabuburit main PUBG");
        activity1.setImg(R.drawable.chickenerangel);
        activityy.add(activity1);

        ActivityModel activity2 = new ActivityModel();
        activity2.setId(3);
        activity2.setDeskripsi("uji fungsi alat");
        activity2.setImg(R.drawable.picture);
        activityy.add(activity2);


    }

     /*   FilmModel film3 = new FilmModel();
        film3.setId(4);
        film3.setNamaFilm("Five Feet Apart");
        film3.setGenreFilm("Drama, Romance");
        film3.setDurasiFilm("116 Minutes");
        film3.setRatingFilm("R 13+");
        films.add(film3);
    }*/


    @Override
    public void save(ActivityModel activity) {
        no++;
        activity.setId(no);
        activityy.add(activity);

        activityView.onSave();
    }

    @Override
    public void update(ActivityModel activity) {
        for (ActivityModel model : activityy) {
            if (model.getId() == activity.getId()) {
                model.setDeskripsi(activity.getDeskripsi());
                model.setImg(activity.getImg());

                break;
            }
        }

        activityView.onUpdate();
    }

    @Override
    public void delete(ActivityModel activity) {
        activityy.remove(activity);

        activityView.onDelete();
    }

    @Override
    public void load() {
        activityView.onLoad(activityy);
    }
}
