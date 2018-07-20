package com.online.dynamicbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

/*
    There are some broadcast we get by simply writing in manifest
    using the broadcast Receiver we can directly use it from the mainactivity
    without adding permission in the manifest

*/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val psr = PowerStateReceiver()
        val ifilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_POWER_CONNECTED)
        }

        registerReceiver(psr,ifilter)
    }

    inner class PowerStateReceiver :BroadcastReceiver( ){
        override fun onReceive(context: Context?, intent: Intent?) {

            if(intent==null)
                return
            if(intent.action== Intent.ACTION_POWER_CONNECTED){
                Toast.makeText(
                        this@MainActivity,
                        "CHARGER CONNECTED",
                        Toast.LENGTH_SHORT
                ).show()
            }

            if(intent.action== Intent.ACTION_POWER_DISCONNECTED){
                Toast.makeText(
                        this@MainActivity,
                        "CHAGER DISCONNECTED",
                        Toast.LENGTH_SHORT
                ).show()
            }

        }

    }
}
