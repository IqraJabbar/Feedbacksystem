package com.example.mehdi.feedbacksystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class Signup extends AppCompatActivity {


    private EditText name1, email1, pass1;
    private Button btn;
    private TextView textView;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        mAuth = FirebaseAuth.getInstance();

        setupViews();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (true) {
                    //uploade the data to the data base;

                    String name = name1.getText().toString().trim();
                    String email = email1.getText().toString().trim();
                    String pass = pass1.getText().toString().trim();
//                    Log.d("USER",email + " "+pass);
//                    mAuth.createUserWithEmailAndPassword(email,pass);
                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(Signup.this, "oncomplete function", Toast.LENGTH_SHORT).show();
                            if (task.isSuccessful()) {
                                Toast.makeText(Signup.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                                Home();
                            } else {
                                Toast.makeText(Signup.this, "Registration Un-Successfully", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }
        });


                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Home();
                        }
                    });


                }

                private void setupViews () {
                    name1 = findViewById(R.id.editText1);
                    email1 = findViewById(R.id.editText2);
                    pass1 = findViewById(R.id.editText3);
                    btn = findViewById(R.id.btn);
                    textView = findViewById(R.id.text);
                }

                private Boolean Validate () {
                    Boolean result = false;
                    String name = name1.getText().toString().trim();
                    String email = email1.getText().toString().trim();
                    String pass = pass1.getText().toString().trim();

                    String Name = "[A-Za-z]";

                    if (name.isEmpty() && email.isEmpty() && pass.isEmpty()) {
                        Toast.makeText(Signup.this, "Please Enter record", Toast.LENGTH_SHORT).show();
                    }

                    if (!name.matches(Name)) {
                        name1.setError("Valid name");
                        name1.requestFocus();
                        return false;
                    }


                    if (email.isEmpty()) {
                        email1.setError("Email is required");
                        email1.requestFocus();
                        return false;
                    }

                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        email1.setError("Enter Valid Email");
                        email1.requestFocus();
                        return false;
                    }
                    if (pass.isEmpty()) {
                        pass1.setError("Password is required");
                        pass1.requestFocus();
                        return false;
                    }

                    if (pass.length() <= 8) {
                        pass1.setError("Minimum length of password should be  8 ");
                        pass1.requestFocus();
                        return false;
                    } else {
//            Home();
                        return true;
                    }

                }


                public void Home () {

                    Intent intent = new Intent(this, login.class);
                    startActivity(intent);
                }
            }
