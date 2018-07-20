package com.online.staticbroadcastreceivers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


/*

Broadcast Receivers
    way in which the app can start
    trigger by events like connected to wifi,airplane mode, language changed,incoming call
    to listen to such events we use brodcast receivers



--->  to make new broadcast receiver
        new> other>broadcast receivers
--->  exported : it can receive message outside the application
      enable :  it can be started by the system

----> In android manifest file , recever tag
                            add
                            <intent-filter>
                             <action android:name="android.intent.action.LOCALE_CHANGED"/>
                             </intent-filter>

*/


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
