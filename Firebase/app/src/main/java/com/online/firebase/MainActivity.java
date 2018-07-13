package com.online.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnDb);
        editText = findViewById(R.id.etNote);


        // dbRef points to the root reference
        final DatabaseReference dbRef =  FirebaseDatabase.getInstance().getReference();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = editText.getText().toString();
                // Upload  the note to Firebase
//                this will create child note and todo and everytime
//                we save the value a unique key will be generated

             dbRef.child("note").push().setValue(note);
             dbRef.child("todo").push().setValue(note);



            }
        });
    }
}

