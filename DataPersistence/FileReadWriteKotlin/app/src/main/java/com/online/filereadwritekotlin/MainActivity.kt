 package com.online.filereadwritekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

 // We need to write very less code as compared to java
 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnWrite.setOnClickListener{
            val dataDir = ContextCompat.getDataDir(this)
            val myFile = File(dataDir,"file.txt" )
            myFile.writeText(editText.text.toString())
        }

        btnRead.setOnClickListener{
            val dataDir = ContextCompat.getDataDir(this)
            val myFile = File(dataDir,"file.txt" )
            textView.text = myFile.readText()
            //This readText method should not be used for very large files
        }
    }
}
