package com.example.hcl.ratingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hcl on 27/1/18.
 */

public class Concat_activity extends AppCompatActivity {
    EditText e1,e2;
    Button b;
    TextView t;
    protected void onCreate(Bundle b1){
        super.onCreate(b1);
        setContentView(R.layout.textconcat);
        e1=findViewById(R.id.edt1);
        e2=findViewById(R.id.edt2);
        b=findViewById(R.id.concat1);
        t=findViewById(R.id.text);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(e1.getText().toString()+e2.getText().toString());
            }
        });


    }
}
