package com.online.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;


/*
    Add permisssion to the  Android  manifest
*/
public class DemoJob extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {
        // whatever task we perform goes here

        jobFinished(params,false);


        Toast.makeText(this, "Hello, I'm a scheduled Job",Toast.LENGTH_LONG).show();
        return false; // false : job is complete do not let it live
    }                 // true: for Async job : there is still work going on, so don't finis this Service just yet

    @Override
    public boolean onStopJob(JobParameters params) {

        // job is complete clean up resources which you are using
        return false;  // false means that we don't wnat to reschedule this job
                      // true  means for the required condition reshedul the task
    }
}
