package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity {

    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bnView = findViewById(R.id.bNavView);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.home){
                    loadFrag(new Home_Fragment(), true);
                }
                else if(id == R.id.cngLocation){
                    loadFrag(new Address_Fragment(), false);
                }
                else if(id == R.id.cart){
                    loadFrag(new Cart_Fragment(),false);
                }
                else if(id == R.id.profile){
                    loadFrag(new Profile_Fragment(),false);
                }
                return true;
            }
        });

        bnView.setSelectedItemId(R.id.home);
    }

    public void loadFrag(Fragment fragment, boolean bol){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(bol) {
            ft.add(R.id.container, fragment);

        }
        else
            ft.replace(R.id.container, fragment);
        ft.commit();
    }
}