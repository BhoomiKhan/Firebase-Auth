package com.pawras.firebaseauthenticaiton;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    FirebaseAuth mAuthAuth= FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        final EditText email = (EditText) findViewById(R.id.email);
        final EditText pass = (EditText) findViewById(R.id.password);

        Button signUp=(Button)findViewById(R.id.sign_up);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mEmail = email.getText().toString();
                final String mPass = pass.getText().toString();
                mAuthAuth.createUserWithEmailAndPassword(mEmail, mPass).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUp.this, "sin up successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void back(View v){
        finish();
    }
}
