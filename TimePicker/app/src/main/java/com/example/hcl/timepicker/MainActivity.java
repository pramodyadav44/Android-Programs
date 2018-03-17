
package com.example.hcl.timepicker;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button b;
    Calendar c;
    int date,month,year;
    int hours,mins,secs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DatePicker dp=new DatePicker(getApplicationContext());
        //TimePicker tp=new TimePicker(getApplicationContext());
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        Button b1=findViewById(R.id.button1);
        tv=findViewById(R.id.date);
        c=Calendar.getInstance();
        date=c.get(Calendar.DATE);
        month=c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);
        hours=c.get(Calendar.HOUR);
        mins=c.get(Calendar.MINUTE);
        secs=c.get(Calendar.SECOND);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Hello First Alert dialog")
                .setPositiveButton("Wow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Nope!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();

                    }
                })
        .setCancelable(false)
        .setTitle("Hello");
        builder.show();
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TimePickerDialog tpd=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        tv.setText(i+":"+(i1));
                    }
                },hours,mins,false);
                        tpd.show();
            }
        });
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DatePickerDialog dpd=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override

                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tv.setText(i+"/"+(i1+1)+"/"+i2);
                    }
                },year,month,date);
                dpd.show();
            }

        });
    }

}
