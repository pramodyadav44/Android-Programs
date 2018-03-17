package com.example.hcl.ratingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by hcl on 27/1/18.
 */

public class togglebutton extends AppCompatActivity{
    ToggleButton t;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiodemo);
        t=findViewById(R.id.toggleButton);
        text=findViewById(R.id.output);
        t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    text.setText("ON");
                }
                else{
                    text.setText("OFF");
                }
            }
        });

    }
}