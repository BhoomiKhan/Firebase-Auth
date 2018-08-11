package com.pawras.firebaseauthenticaiton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CRUID extends AppCompatActivity {

    Firebase mFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cruid);
        mFirebase.setAndroidContext(this);
        mFirebase.child("name").setValue("fhgh");
        mFirebase = new Firebase("https://fir-authentication-bf8f0.firebaseio.com/");
        mFirebase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               String value= dataSnapshot.getValue(String.class);
                Toast.makeText(CRUID.this, "value is "+value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

         DatabaseReference mDatabase;
         mDatabase = FirebaseDatabase.getInstance().getReference();
         mDatabase.child("name").setValue("afzal khan");
    }
}