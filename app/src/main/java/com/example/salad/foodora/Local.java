package com.example.salad.foodora;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by salad on 2/5/16.
 */
public class Local extends AppCompatActivity {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.local_container);

        if(fragment == null)
        {
            fragment = new FragmentLocal();
            fm.beginTransaction().add(R.id.local_container,fragment).commit();
        }


    }
}
