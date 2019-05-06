package com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.FavoriteModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.View.FavoriteView;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImplFavorite implements MainPresenterFavorite {

    private FavoriteView favoriteView;

    private List<FavoriteModel> favorite = new ArrayList<>();
    private int no = 4;

    public MainPresenterImplFavorite(FavoriteView favoriteView) {
        this.favoriteView = favoriteView;
        setData();
    }

    private void setData() {
        FavoriteModel fav = new FavoriteModel();
        fav.setId(1);
        fav.setVideo("babysharkapip");
        fav.setDeskripsi("baby");
        favorite.add(fav);


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
    public void save(FavoriteModel fav) {
        no++;
        fav.setId(no);
        favorite.add(fav);

        favoriteView.onSave();
    }

    @Override
    public void update(FavoriteModel fav) {
        for (FavoriteModel model : favorite) {
            if (model.getId() == fav.getId()) {
                model.setVideo(fav.getVideo());

                break;
            }
        }

        favoriteView.onUpdate();
    }

    @Override
    public void delete(FavoriteModel fav) {
        favorite.remove(fav);

        favoriteView.onDelete();
    }

    @Override
    public void load() {
        favoriteView.onLoad(favorite);
    }
}
