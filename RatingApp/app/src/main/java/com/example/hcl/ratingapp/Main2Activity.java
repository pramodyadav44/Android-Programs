package com.example.hcl.ratingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    CheckBox c1,c2,c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        c1=findViewById(R.id.ch1);
        c2=findViewById(R.id.ch2);
        c3=findViewById(R.id.ch3);
        //Using click listener
        //c1.setOnClickListener(this);
        //c2.setOnClickListener(this);
        //c3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.ch1){
            if(c1.isChecked()){
                Toast.makeText(getApplicationContext(),"Checked Eating",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"unchecked Eating",Toast.LENGTH_SHORT).show();
            }
        }
        else if(view.getId()==R.id.ch2){

            if(c2.isChecked()){
                Toast.makeText(getApplicationContext(),"Checked Sleeping",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"unchecked Sleeping",Toast.LENGTH_SHORT).show();
            }

        }
        else if(view.getId()==R.id.ch3){

            if(c3.isChecked()){
                Toast.makeText(getApplicationContext(),"Checked Studying",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"unchecked Studying",Toast.LENGTH_SHORT).show();
            }
        }
    }
    //without using listener
    public void checkBox(View v){
        switch (v.getId()){
            case R.id.ch1:
                if(c1.isChecked()){
                    toastMe("Checked eating");
                }
                else{

                    toastMe("unchecked Eating");
                }
                break;
            case(R.id.ch2):

                if(c2.isChecked()){
                    toastMe("Checked Sleeping");
                }
                else{
                    toastMe("unchecked Sleeping");
                }
                break;
            case(R.id.ch3):
                if(c3.isChecked()){
                    toastMe("checked Studying");
                }
                else{
                    toastMe("Unchecked Studying");
                }
        }
    }
    public void toastMe(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
