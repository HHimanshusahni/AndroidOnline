package com.online.firebase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/*
    READING DATA FROM FIREBASE DATABASE

    Reading the data from the database
    showing data saved in the note

    firebase is a Realtime database
    Realtime:  whenever data in database is updated
                all devices get callback from the database

   Custom objects can be saved in the real time database as long as they are having the primitive data types
    eg Context can't be saved

    CHILD EVENT LISTENER

    VALUE EVENT LISTENER
        --> everytime the database is updated it gives the entire database and
        --> not the child that is updated
        --> rarely used
        --> increaces load as entire data is coming

*/

public class MainActivity extends AppCompatActivity {


    Button button;
    EditText editText;

    ArrayList<String> notes;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnDb);
        editText = findViewById(R.id.etNote);
        listView = findViewById(R.id.listView);
        notes = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.item_row,
                R.id.tViewList,
                notes);

        listView.setAdapter(arrayAdapter);

        final DatabaseReference dbRef =  FirebaseDatabase.getInstance().getReference();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                1  for demo purpose only
                String note = editText.getText().toString();

//1                Note n = new Note("Hello","WORLD");


                dbRef.child("note").push().setValue(note);


            }
        });



        dbRef.child("note").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                Called when a new data nodeis insertedin the "note" node

                // pass the class with which data to be matched
               String data =  dataSnapshot.getValue(String.class);
               notes.add(data);
               arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                An Existing data is node is updated
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//              When a data at a subnode is removed
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//              When the position of subNode Changes
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // When the read operation failed
            }
        });



    }
}

