package com.example.mehdi.feedbacksystem;

import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URI;
import java.net.URL;

public class FeedbackActivity extends AppCompatActivity {

    EditText tvcourse, tvsemester,tvdept,tvReview,tvSuggestn;
    Button send, detail;
    Firebase firebase;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        tvcourse=findViewById(R.id.name);
        tvsemester=findViewById(R.id.sems);
        tvdept=findViewById(R.id.dept);
        tvReview=findViewById(R.id.msg);
        tvSuggestn=findViewById(R.id.msg1);

        send=findViewById(R.id.btn);
        detail=findViewById(R.id.btn1);

        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Feedback");

        // get reference to 'users' node
       // mFirebaseDatabase = mFirebaseInstance.getReference("Feedback");

        // store app title to 'app_title' node
        //mFirebaseInstance.getReference("app_title").setValue("Realtime Database");

        Firebase.setAndroidContext(this);

        send.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                detail.setEnabled(true);
                final String course= tvcourse.getText().toString();
                final String semester=tvsemester.getText().toString();
                final String dept=tvdept.getText().toString();
                final String review=tvReview.getText().toString();
                final String suggestion=tvSuggestn.getText().toString();

                if (TextUtils.isEmpty(userId)) {
                   // userId = mFirebaseDatabase.push().getKey();
                }

                Feedback feedback = new Feedback(course, Integer.parseInt(semester), dept,review,suggestion);
                mFirebaseDatabase.push().setValue(feedback);
                Toast.makeText(FeedbackActivity.this, "Doneee", Toast.LENGTH_LONG).show();

               // mFirebaseDatabase.child(userId).setValue(feedback);

                //mFirebaseDatabase.child("test").child(userId).child("course").setValue(course);

                /*Firebase child_course=firebase.child("Course");
                child_course.setValue(course);
                if (course.isEmpty())
                {
                    tvcourse.setError("This is an required field!");
                    send.setEnabled(false);
                }
                else {
                    tvcourse.setError(null);
                    send.setEnabled(true);

                }

                Firebase child_semester=firebase.child("Semester");
                child_semester.setValue(semester);
                if (semester.isEmpty())
                {
                    tvsemester.setError("This is an required field!");
                    send.setEnabled(false);
                }
                else {
                    tvsemester.setError(null);
                    send.setEnabled(true);

                }

                Firebase child_department=firebase.child("Department");
                child_department.setValue(dept);
                if (dept.isEmpty())
                {
                    tvdept.setError("This is an required field!");
                    send.setEnabled(false);
                }
                else {
                    tvdept.setError(null);
                    send.setEnabled(true);

                }

                Firebase child_review=firebase.child("Review");
                child_review.setValue(review);
                if (review.isEmpty())
                {
                    tvReview.setError("This is an required field!");
                    send.setEnabled(false);
                }
                else {
                    tvReview.setError(null);
                    send.setEnabled(true);

                }

                Firebase child_suggestion=firebase.child("Suggestion");
                child_suggestion.setValue(suggestion);
                if (suggestion.isEmpty())
                {
                    tvSuggestn.setError("This is an required field!");
                    send.setEnabled(false);
                }
                else {
                    tvSuggestn.setError(null);
                    send.setEnabled(true);

                }*/
                detail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new AlertDialog.Builder(FeedbackActivity.this)
                                .setTitle("Sended Details:")
                                .setMessage("Course- " + course +"\n\nSemester- " + semester +"\n\nDepartment- " + dept +"\n\nReview-" + review +"\n\nSuggestion- " + suggestion)
                                .show();

                    }
                } );


            }
        });
        //String UniqueID = Settings.Secure.getString(getApplicationContext().getContentResolver(),Settings.Secure._ID);
        //String UniqueID = Settings.Secure.getString(getApplicationContext().getContentResolver().Settings.Secure);

        //firebase = new Firebase("https://homepage-53f5d.firebaseio.com");

    }
}