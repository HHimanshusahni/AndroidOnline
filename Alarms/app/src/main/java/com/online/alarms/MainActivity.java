package com.online.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Pending intent is like a token we give to the framework
that if the app is not active use this pending intent to perform the  task
instead of the intent

PendingIntent.getActivity() is used  to fire intent i which open the new activity

if the intent i  fires instead of .getActivity() we use
        service use -->PendingIntent.getService()
        broadcast use -->PendingIntent.getBroadcast()
--------------------------------------------------------

FLAG_ONE_ SHOT --->used for single time

FLAG_NO_CREATE ----> if the intent is not created it will not create the new intent to send

FLAG_CANCEL_CURRENT---> if the pending intent is send twice then it will cancel the current one and send the new one

FLAG_UPDATE_CURRENT---> it won't cancel the current one it update the current one with new data

FLAG_IMMUTABLE -->once created it can't be changed
 --------------------------------------------------------
        TYPES OF ALARMS


  ELASPED_REALTIME  ---> it takes accont of time  spent since the last boot

  ELSPED_REALTIME_WAKEUP --->
  RTC ---->  consider the current real world time i.e. System.currentTimeMillis()

  RTC_WAKEUP --->

NOTE wakeup : when phone gets into active state when it is in the sleep mode

----------------------------------------------------------

alarmManager.set () ---> triggers the alaram only once
alarmMangger.setRepeatingAlarmManager ---> trigger the alarm multiple times after interval
                        --->
alarmManager.setInexactRepeating --> the deadline is not exactly fixed
                                 --> it is preferred as it will not drain battery too much and wake up phone unnecerraliy


----------------------------------------------
JOB SCHEDULER is preferred over alarms

*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnTask = findViewById(R.id.btnTask);

        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(),Main2Activity.class);
//                PendingIntent pi = PendingIntent.getActivity(getBaseContext(),12345,i,PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pi = PendingIntent.getActivity(getBaseContext(),12345,i,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime()+60000,
                        60000,pi);

            }
        });
    }


}
