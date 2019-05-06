package com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.FriendsModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.R;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.View.FriendsView;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImplFriends implements MainPresenterFriends {

    private FriendsView friendsView;

    private List<FriendsModel> friends = new ArrayList<>();
    private int no = 4;

    public MainPresenterImplFriends(FriendsView friendsView) {
        this.friendsView = friendsView;
        setData();
    }

    private void setData() {
        FriendsModel friend = new FriendsModel();
        friend.setId(1);
        friend.setNama("Alam");
        friend.setImg(R.drawable.alam);
        friends.add(friend);

        FriendsModel friend1 = new FriendsModel();
        friend1.setId(2);
        friend1.setNama("Idin");
        friend1.setImg(R.drawable.idin);
        friends.add(friend1);

        FriendsModel friend2 = new FriendsModel();
        friend2.setId(3);
        friend2.setNama("Sarah");
        friend2.setImg(R.drawable.sarah);
        friends.add(friend2);

        FriendsModel friend3 = new FriendsModel();
        friend3.setId(4);
        friend3.setNama("Sissy");
        friend3.setImg(R.drawable.sissy);
        friends.add(friend3);


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
    public void save(FriendsModel friend) {
        no++;
        friend.setId(no);
        friends.add(friend);

        friendsView.onSave();
    }

    @Override
    public void update(FriendsModel friend) {
        for (FriendsModel model : friends) {
            if (model.getId() == friend.getId()) {
                model.setNama(friend.getNama());
                model.setImg(friend.getImg());

                break;
            }
        }

        friendsView.onUpdate();
    }

    @Override
    public void delete(FriendsModel friend) {
        friends.remove(friend);

        friendsView.onDelete();
    }

    @Override
    public void load() {
        friendsView.onLoadf(friends);
    }
}
