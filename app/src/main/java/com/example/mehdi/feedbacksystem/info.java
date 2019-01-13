package com.example.mehdi.feedbacksystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class info extends AppCompatActivity {

    EditText pname,sems,dept;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        pname=findViewById(R.id.name);
        sems=findViewById(R.id.sems);
        dept=findViewById(R.id.dept);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Submit();
            }
        });
    }
    public  void  Submit(){
        String Student_name = pname.getText().toString().trim();
        String Semester = sems.getText().toString().trim();
        String Department = dept.getText().toString().trim();


        if (Student_name.isEmpty()) {
            pname.setError("Name must be is required");
            pname.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(Student_name).matches()) {
            pname.setError("Enter Valid Email");
            pname.requestFocus();
            return;
        }



        if (Semester.isEmpty()) {
            sems.setError("Semester is required");
            sems.requestFocus();
            return;
        }

        if((Semester=="1")||(Semester=="2")||(Semester=="3")||(Semester=="4")||(Semester=="5")||(Semester=="6")||(Semester=="7")||(Semester=="8")){

            sems.setError("Semester  must be 1-8");
            sems.requestFocus();
            return;
        }


        if (Department.isEmpty()) {
            dept.setError("Department is required");
            dept.requestFocus();
            return;
        }





        else
        {
            Intent intent=new Intent(info.this,HomePage.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"sucessfull...", Toast.LENGTH_SHORT).show();
        }


    }
}
