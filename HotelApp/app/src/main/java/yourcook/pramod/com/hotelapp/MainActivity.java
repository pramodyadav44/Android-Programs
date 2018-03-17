package yourcook.pramod.com.hotelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import yourcook.pramod.com.hotelapp.Model.UserData;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    RadioGroup rg;
    RadioButton rb1,rb2;
    Button b;
    String radioVal,food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        rg=findViewById(R.id.rg);
        rb1=findViewById(R.id.ac);
        rb2=findViewById(R.id.nonac);
        b=findViewById(R.id.button);
        final ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.food));
        spinner.setAdapter(adapter);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rg.getCheckedRadioButtonId()==R.id.ac) {
                    radioVal="AC";
                }else{
                    radioVal="Non AC";
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food=spinner.getSelectedItem().toString();
                if(radioVal!=null && food!=null) {
                     new DatabaseHelper(MainActivity.this).addData(new UserData(food,radioVal));
                }
                else{
                    Toast.makeText(getApplicationContext(),"All fields are mandatory",Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.fetchdata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<UserData> data=new DatabaseHelper(MainActivity.this).fetchData();
                String x="";
                for (UserData userData:data){
                    x += userData.getFood() + " " + userData.getCategory() + "\n";
                }
                Toast.makeText(getApplicationContext(),x,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
