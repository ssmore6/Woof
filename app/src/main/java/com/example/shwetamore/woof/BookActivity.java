package com.example.shwetamore.woof;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        addButtonListener();
    }

    public void addButtonListener(){
        Button findSitter = (Button) findViewById(R.id.button2);
        findSitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapScreen = new Intent(BookActivity.this, SitActivity.class);
                startActivity(mapScreen);
            }
        });

        ImageButton scheduleButton = (ImageButton) findViewById(R.id.imageButton);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schedule = new Intent(BookActivity.this, ScheduleActivity.class);
                startActivity(schedule);
            }
        });
    }

}
