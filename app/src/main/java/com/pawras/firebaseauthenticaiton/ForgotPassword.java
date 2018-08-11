package com.pawras.firebaseauthenticaiton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.forgot_password);
       final FirebaseAuth mFirebaseAuth=FirebaseAuth.getInstance();
       final EditText mEditText=(EditText) findViewById(R.id.email);
       Button mButton=(Button) findViewById(R.id.recover);

       mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString()!=null){
                    mFirebaseAuth.sendPasswordResetEmail(mEditText.getText().toString());
                    Toast.makeText(ForgotPassword.this, "Recovery Email Sent", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ForgotPassword.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}