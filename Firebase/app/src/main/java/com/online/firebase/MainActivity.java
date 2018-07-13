package com.online.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = editText.getText().toString();
                // Upload  the note to Firebase

                // getting reference to root database
                // .setvalue() to upload the value to the root node in console
                // but this updates the existing value at the node instead of creating new node

//                FirebaseDatabase.getInstance().getReference().setValue(note);


                // push creates the new node for every value
                FirebaseDatabase.getInstance().getReference().push().setValue(note);



            }
        });
    }
}

