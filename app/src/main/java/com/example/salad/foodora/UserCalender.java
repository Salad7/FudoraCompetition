package com.example.salad.foodora;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by salad on 2/7/16.
 */


public class UserCalender extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.activity_calender_container);

        if (fragment == null) {
            fragment = new FragmentCalender();
            fm.beginTransaction().add(R.id.activity_calender_container,fragment).commit();
        }
    }
}
