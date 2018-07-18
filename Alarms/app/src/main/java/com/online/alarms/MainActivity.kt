package com.online.alarms

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/*
* AlarmManager class is used to set Alarms

* From Developer documentation
* --> used in intents
* --> can be used with broadcast reciever
* --> can be used to start services
*
* Even when the app is not running still alarms can fire
* Alarms saves using the mobile resources unnecceraily
*
* we should not misuse alarms as  poorly designed can drain battery
*
*
*
* */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
