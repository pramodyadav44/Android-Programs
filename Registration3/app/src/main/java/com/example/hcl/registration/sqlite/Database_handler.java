package com.example.hcl.registration.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hcl.registration.model.Student_details;

/**
 * Created by hcl on 3/2/18.
 */

public class Database_handler extends SQLiteOpenHelper{
    public static int DATABASE_VERSION=1;
    public static String DATABASE_NAME="user.db";
    public static String TABLE_NAME="users";
    public static String COL1_NAME="user_id";
    public static String COL2_NAME="user_name";
    public static String COL3_NAME="user_mobile";
    public static String COL4_NAME="user_address";
    public static String COL5_NAME="Email_id";
    private Context context;
    public Database_handler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            String query="create table "+TABLE_NAME+"("+COL1_NAME+" integer(2) primary key,"+COL2_NAME+" varchar(10),"+COL3_NAME+" integer(11),"+COL4_NAME+" varchar(25),"+COL5_NAME+" varchar(20));";
            Log.d("query",query);
            sqLiteDatabase.execSQL(query);

        }
        catch(Exception e){
            Log.d("in catch","Unable to create");

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);


    }

    public void adduser(Student_details stud ){
        try {
            SQLiteDatabase sql = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL1_NAME, stud.getId());
            values.put(COL2_NAME, stud.getName());
            values.put(COL3_NAME, stud.getMob_number());
            values.put(COL4_NAME, stud.getAddress());
            values.put(COL5_NAME, stud.getEmail());
            sql.insertOrThrow(TABLE_NAME, null,values);
            sql.close();
            Log.i("insert", "fail to onsert deatils");
        }

        catch(Exception e){


        }
    }
}
