package com.online.jobscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



/*
    Job Scheduler is the better way to schedule task as compared to alams
    USES
        --> allow to set the task only when the certain criteria is fulfilled
        --> we can specify requirement  for network and battery
    ALTERNATIVES
        Firebase JobDispatcher  ---> mush have google  playservice on phone
        Sync adapter  ---> now obselete
    ---------------------------------------------
    for every job we create we need to extend for  jobservice class


* */
public class MainActivity extends AppCompatActivity {


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
