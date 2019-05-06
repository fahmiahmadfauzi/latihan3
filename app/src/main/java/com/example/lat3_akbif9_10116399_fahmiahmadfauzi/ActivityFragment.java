package com.example.lat3_akbif9_10116399_fahmiahmadfauzi;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Adapter.RecyclerViewActivityAdapter;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Adapter.RecyclerViewFriendsAdapter;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.ActivityModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Model.FriendsModel;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter.MainPresenterActivity;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter.MainPresenterFriends;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter.MainPresenterImplActivity;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.Presenter.MainPresenterImplFriends;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.View.ActivityView;
import com.example.lat3_akbif9_10116399_fahmiahmadfauzi.View.FriendsView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityFragment extends Fragment implements ActivityView, FriendsView {

    private RecyclerView recyclerView, recyclerViewF;
    private RecyclerViewActivityAdapter adapter;
    private RecyclerViewFriendsAdapter adapterf;
    private List<FriendsModel> friendsList = new ArrayList<>();
    private List<ActivityModel> activityList = new ArrayList<>();
    private MainPresenterActivity presenter;
    private MainPresenterFriends presenterf;


    public ActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View activityfragment = inflater.inflate(R.layout.fragment_activity, container, false);
        presenter = new MainPresenterImplActivity(this);
        presenterf = new MainPresenterImplFriends(this);

        recyclerView = activityfragment.findViewById(R.id.recyclerview_activity);
        recyclerViewF = activityfragment.findViewById(R.id.recyclerview_friends);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterf = new RecyclerViewFriendsAdapter(getActivity(), friendsList);

        adapter = new RecyclerViewActivityAdapter(getActivity(), activityList);
        LinearLayoutManager horizontallayoutmanager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewF.setLayoutManager(horizontallayoutmanager);
        recyclerViewF.setAdapter(adapterf);
        presenterf.load();

        recyclerView.setAdapter(adapter);
        presenter.load();

        return activityfragment;
    }

    @Override
    public void onLoad(List<ActivityModel> activity) {
        activityList.clear();
        activityList.addAll(activity);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onLoadf(List<FriendsModel> friend) {
        friendsList.clear();
        friendsList.addAll(friend);

        adapterf.notifyDataSetChanged();

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
