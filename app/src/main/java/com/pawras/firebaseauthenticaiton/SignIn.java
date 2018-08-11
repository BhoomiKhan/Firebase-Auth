package com.pawras.firebaseauthenticaiton;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        auth=FirebaseAuth.getInstance();
        final EditText email = (EditText) findViewById(R.id.email);
        final  EditText pass = (EditText) findViewById(R.id.pass);
        Button btn=(Button)findViewById(R.id.sign_in);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mEmail = email.getText().toString();
                final String mPass = pass.getText().toString();

                if (mEmail != null && mPass != null) {
                    //authenticate user
                    auth.signInWithEmailAndPassword(mEmail, mPass)
                            .addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(SignIn.this, "Wrong email/password", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(SignIn.this, "logged in with " + mEmail, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else
                    Toast.makeText(SignIn.this, "Email or password should not be null", Toast.LENGTH_SHORT).show();
            }
                });
            }
    
    public void back(View v){
        finish();
    }
}
