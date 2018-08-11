package com.pawras.firebaseauthenticaiton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth ;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth= FirebaseAuth.getInstance();
    }

    public void cruid(View v){
        Intent i=new Intent(MainActivity.this,CRUID.class);
        startActivity(i);
    }

    public void google_signin(View v){
        Intent i=new Intent(MainActivity.this,GoogleSignIn.class);
        startActivity(i);
    }
    public void signin(View v){
        Intent i=new Intent(MainActivity.this,SignIn.class);
        startActivity(i);
    }
    public void signUp(View v){
        Intent i=new Intent(MainActivity.this,SignUp.class);
        startActivity(i);
    }
}