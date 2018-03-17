package com.example.hcl.al;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    Button b ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=findViewById(R.id.ed);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarm();
            }
        });
    }
    public void setAlarm(){
        int sec=Integer.parseInt(edt1.getText().toString());
        AlarmManager am= (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent p=PendingIntent.getBroadcast(this,0,new Intent(MainActivity.this,AlarmBroadcast.class),0);
        am.set(AlarmManager.RTC_WAKEUP,sec*1000,p);
    }
}

