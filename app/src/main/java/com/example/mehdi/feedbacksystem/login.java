package com.example.mehdi.feedbacksystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    ImageView img;
    EditText email1,pass1;
    Button btn;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        img = findViewById(R.id.img1);
        email1 = findViewById(R.id.editText);

        pass1 = findViewById(R.id.editText2);
        btn = findViewById(R.id.btn);
        text = findViewById(R.id.text);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Home();
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signup();
            }
        });

    }


    public void Home() {



        String email = email1.getText().toString().trim();
        String pass = pass1.getText().toString().trim();

        if (email.isEmpty()) {
            email1.setError("Email is required");
            email1.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email1.setError("Enter Valid Email");
            email1.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            pass1.setError("Password is required");
            pass1.requestFocus();
            return;
        }

        if (pass.length() < 8) {
            pass1.setError("Minimum length of password should be  8 ");
            pass1.requestFocus();
            return;
        } else {

            Toast.makeText(login.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
            Intent customerIntend = new Intent(login.this, HomePage.class);
            startActivity(customerIntend);
        }
    }


                public void signup() {
                    Intent intent = new Intent(login.this, Signup.class);
                    startActivity(intent);
                }
            }
