package com.example.hcl.registration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hcl.registration.sqlite.Database_handler;

public class secondpage extends AppCompatActivity {
    String c="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        TextView w=findViewById(R.id.weltext);
        Database_handler db=new Database_handler(this);
        SQLiteDatabase sql=db.getReadableDatabase();
        Cursor cursor=sql.rawQuery("select * from users",null);
        while(cursor.moveToNext()){
            c=cursor.getString(1)+"\n"+c;

        }
        w.setText(c);

    }
}
