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
FireBase Introduction
        -> Builds app without establishing server
        -> can use cloud services


Refer the website
https://firebase.google.com

Realtime Database ---> host the website
Performanch Monitoring
Crashlytics
Authentication  --> for login
cloud storage
Test Lab
Analytics ---> provide which part of world has users


-----------------------------------------------
 Developer  part of  firebase

 step 1  sign in

 Explore the Demo project

   Project Overview
          Authentication  -- > login option
                          --> details of user are giver
          Database  --> not a sql database
          Storage   --> upload the file on server and then
                        send the link to other user
          Hosting --> host the website
          Function
        Can the skip the hosting and function part for now

  STABILITY

            Crashalytics
            Performance
            Test Lab -- > for running device
                          on a real device or emulator
            Analytice --> shows demographic of users
                          active user
                          new user
                          conversion
                          dialy user engagement
                          revenue part
                          stability graph --> crash percentage
                          what version are user on
                          media by which people find your  app  on playstore
                          Retentation  ---> as time progresses user decreases
                          Audience from the world
                          Devices
                          Gender of the user

    GROW
                Predictions Beta version
                Notification  --> create an notication
                              --> can filter and targer specific user
                              --> powerful tool don't misuse

                Remote Config --> eg change color button from red to blue
                                     without updating your app on playstore

                Dynamics Links --> Deep linking
                                    getting user to go to another app
                                    or downloading from playstore



*/