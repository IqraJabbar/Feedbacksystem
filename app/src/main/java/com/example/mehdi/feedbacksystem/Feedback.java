package com.example.mehdi.feedbacksystem;

//import com.google.firebase.database.IgnoreExtraProperties;

//@IgnoreExtraProperties
public class Feedback {

    public String course;
    public int semester;
    public String dept;
    public String review;
    public String suggestion;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Feedback() {
    }

    public Feedback(String course, int semester, String dept,String review,String suggestion) {
        this.course = course;
        this.semester = semester;
        this.dept = dept;
        this.review = review;
        this.suggestion = suggestion;
    }
}

