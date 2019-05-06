package com.example.lat3_akbif9_10116399_fahmiahmadfauzi;
//tanggal 04-05-2019
//nim : 10116399
//nama : fahmi ahmad fauzi
//kelas : if-9 / akb - 9

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnMulai;
    Animation btnAnim;
    private ViewPager screenPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);

        tabIndicator = findViewById(R.id.tab_indicator);
        btnMulai = findViewById(R.id.btn_mulai);


        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("iniLaundry", "iniLaundry merupakan aplikasi yang cocok buat kalian untuk mencari tempat laundry", R.drawable.logoo));
        mList.add(new ScreenItem("Filter", "Filter merupakan fitur agar kamu bisa cari laundry sesuai keinginan kamu", R.drawable.cari));
        mList.add(new ScreenItem("Maps", "Maps merupakan fitur cari laundry yang terdekat dari kamu", R.drawable.map));


        screenPager = findViewById(R.id.screen_pager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);

        //set tablayout
        tabIndicator.setupWithViewPager(screenPager);

        //TABLAYOUT ADD CHANGE LISTENER

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size() - 1) {
                    loadlastscreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main2activity = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(main2activity);
            }
        });


    }


    private void loadlastscreen() {
        btnMulai.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);

        btnMulai.setAnimation(btnAnim);


    }
}
