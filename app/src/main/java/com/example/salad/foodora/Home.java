package com.example.salad.foodora;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import com.parse.ParseObject;
import com.example.salad.foodora.widget.ClipRevealFrame;
import com.ogaclejapan.arclayout.ArcLayout;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class Home extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //rootLayout = findViewById(R.id.root_layout);
        //menuLayout = (ClipRevealFrame) findViewById(R.id.menu_layout);
        //arcLayout = (ArcLayout) findViewById(R.id.arc_layout);

        Button mCreate = (Button) findViewById(R.id.button_create);
        Button mLocal = (Button) findViewById(R.id.button_local);
        Button mCalender = (Button) findViewById(R.id.button_calender);

        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
                Intent barbie = new Intent(getApplicationContext(),CreateEvent.class);
                startActivity(barbie);
            }
        });

    mLocal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent barbie = new Intent(getApplicationContext(),Local.class);
            startActivity(barbie);
        }
    });

        mCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent barbie = new Intent(getApplicationContext(),UserCalender.class);
                startActivity(barbie);
            }
        });
        Parse.enableLocalDatastore(this);

        Parse.initialize(this);
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        ParseInstallation.getCurrentInstallation().saveInBackground();
}
    public void onCreate() {
        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
