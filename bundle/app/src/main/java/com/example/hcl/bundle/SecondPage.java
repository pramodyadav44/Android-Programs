package com.example.hcl.bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class SecondPage extends AppCompatActivity {
    TextView txt1,txt2,txt3;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.secondpage);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        //Bundle
        /*Intent i = getIntent();
        String name1=i.getStringExtra("f_name");
        String name2=i.getStringExtra("s_name");
        String name3=i.getStringExtra("roll");
        txt1.append(name1);
        txt2.append(name2);
        txt3.append(name3);*/
        //using java class
        txt1.append(DataHelper.f_name);
        txt2.append(DataHelper.s_name);
        txt3.append(DataHelper.roll);



    }
}
