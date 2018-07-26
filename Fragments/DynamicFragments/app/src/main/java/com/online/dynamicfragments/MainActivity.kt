package com.online.dynamicfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFruits.setOnClickListener{
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flFragContainer,FruitsFragment())
                    .commit()
        }
        btnVegetables.setOnClickListener{
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flFragContainer,VegetabeFragment())
                    .commit()
        }
    }
}
