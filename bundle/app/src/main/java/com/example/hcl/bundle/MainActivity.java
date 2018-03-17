package com.example.hcl.bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2,editText3;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.edt1);
        editText2=findViewById(R.id.edt2);
        editText3=findViewById(R.id.edt3);
        bt1=findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bundle
                /*Bundle bundle=new Bundle();
                bundle.putString("f_name",editText1.getText().toString());
                bundle.putString("s_name",editText2.getText().toString());
                bundle.putString("roll",editText3.getText().toString());
                */
                //using class file
                DataHelper.f_name=editText1.getText().toString();
                DataHelper.s_name=editText2.getText().toString();
                DataHelper.roll=editText3.getText().toString();
                Intent i=new Intent(MainActivity.this,SecondPage.class);
                //i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
