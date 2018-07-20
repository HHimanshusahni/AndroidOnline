package com.online.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//https://developer.android.com/reference/android/app/job/JobScheduler
//https://medium.com/google-developers/scheduling-jobs-like-a-pro-with-jobscheduler-286ef8510129

/*
    Job Scheduler is the better way to schedule task as compared to alams
    The minimum api versino it uses is 21
    USES
        --> allow to set the task only when the certain criteria is fulfilled
        --> we can specify requirement  for network and battery
    ALTERNATIVES
        Firebase JobDispatcher  ---> mush have google  playservice on phone ; min api 14
        Sync adapter  ---> now obselete
    ---------------------------------------------
    for every job we create we need to extend for  jobservice class


* */

public class MainActivity extends AppCompatActivity {
    public static final int JOB_ID = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scheduleJob(View view) {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        JobInfo jobInfo = new JobInfo.Builder(JOB_ID, new ComponentName(this,DemoJob.class))
                .setPeriodic(1200000)   //min periodic interval is  15 min
                .setPersisted(true)  // add the permisson in the manifest
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresCharging(true)
                .build();
        jobScheduler.schedule(jobInfo);
    }
}
