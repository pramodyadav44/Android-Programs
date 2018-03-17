package com.example.hcl.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.hcl.registration.model.Student_details;
import com.example.hcl.registration.sqlite.Database_handler;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText name,email,mobile,address;
    //RadioGroup rg1;
   // RadioButton rb1,rb2;



    Database_handler db;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        db=new Database_handler(this);

    }
    private void initUI(){
        b=findViewById(R.id.submit);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        mobile=findViewById(R.id.mobile);
        address=findViewById(R.id.addr);

        b.setOnClickListener(this);
    }
    @Override

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submit:
                Student_details student_details=new Student_details();
                student_details.setName(name.getText().toString());
                student_details.setEmail(email.getText().toString());
                student_details.setMob_number(Integer.parseInt(mobile.getText().toString()));
                student_details.setAddress(address.getText().toString());
                db.adduser(student_details);
                Intent i=new Intent(MainActivity.this,secondpage.class);
                startActivity(i);
                break;
        }
    }
    public void customToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
        //db.adduser(new StudentDetails())
    }

}
