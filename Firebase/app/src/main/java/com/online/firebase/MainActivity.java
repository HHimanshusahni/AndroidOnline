package com.online.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
/*
---------------------------------------------------------
 How to integrate cloud database to our  app

Databases>> Add Realtime data bases

        locked mode -> pvt database
                    -> no value can added from app to console
                    -> only value from console can be added
                        to the app
        test mode -> everone will be able to write data to database

 select test mode
 can change the  rules later on


    Now we can add value in data base from the console

    KEY --VALUE PAIRING OF THE DATABASE
    --> json format
    --> not a sql database
    --> we can only store primitives data types here

    EXPORT JSON
                downloads database in json format

In IDE

Assitant> RealtimeDatabase> Click play button
        > Add the Realtime Database to your app

adds dependency update it in the gradle file
----------------------------------------------------




*/
