package com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.GalleryModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.R;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.View.GalleryView;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImplGallery implements MainPresenterGallery {

    private GalleryView galleryView;

    private List<GalleryModel> gallery = new ArrayList<>();
    private int no = 4;

    public MainPresenterImplGallery(GalleryView galleryView) {
        this.galleryView = galleryView;
        setData();
    }

    private void setData() {
        GalleryModel galler = new GalleryModel();
        galler.setId(1);
        galler.setImg(R.drawable.alam);
        gallery.add(galler);

        GalleryModel galler1 = new GalleryModel();
        galler1.setId(2);
        galler1.setImg(R.drawable.impulse);
        gallery.add(galler1);

        GalleryModel galler2 = new GalleryModel();
        galler2.setId(3);
        galler2.setImg(R.drawable.idin);
        gallery.add(galler2);

        GalleryModel galler3 = new GalleryModel();
        galler3.setId(4);
        galler3.setImg(R.drawable.sarah);
        gallery.add(galler3);

        GalleryModel galler4 = new GalleryModel();
        galler4.setId(5);
        galler4.setImg(R.drawable.sissy);
        gallery.add(galler4);

        GalleryModel galler5 = new GalleryModel();
        galler5.setId(6);
        galler5.setImg(R.drawable.chicken);
        gallery.add(galler5);

        GalleryModel galler6 = new GalleryModel();
        galler6.setId(7);
        galler6.setImg(R.drawable.chickenerangel);
        gallery.add(galler6);

        GalleryModel galler7 = new GalleryModel();
        galler7.setId(8);
        galler7.setImg(R.drawable.bpkkos);
        gallery.add(galler7);

        GalleryModel galler8 = new GalleryModel();
        galler8.setId(9);
        galler8.setImg(R.drawable.picture);
        gallery.add(galler8);

        GalleryModel galler9 = new GalleryModel();
        galler9.setId(10);
        galler9.setImg(R.drawable.fahmi);
        gallery.add(galler9);


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
    public void save(GalleryModel galler) {
        no++;
        galler.setId(no);
        gallery.add(galler);

        galleryView.onSave();
    }

    @Override
    public void update(GalleryModel galler) {
        for (GalleryModel model : gallery) {
            if (model.getId() == galler.getId()) {
                model.setImg(galler.getImg());

                break;
            }
        }

        galleryView.onUpdate();
    }

    @Override
    public void delete(GalleryModel galler) {
        gallery.remove(galler);

        galleryView.onDelete();
    }

    @Override
    public void load() {
        galleryView.onLoad(gallery);
    }
}
