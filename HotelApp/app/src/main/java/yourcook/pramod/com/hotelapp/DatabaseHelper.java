package yourcook.pramod.com.hotelapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import yourcook.pramod.com.hotelapp.Model.UserData;

/**
 * Created by pramod on 17/3/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;

    public DatabaseHelper(Context context){

        super(context,"Hotel",null,1);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table UserData(id int(10) primary key,category varchar(20),food varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Hotel");
        onCreate(db);
    }
    public void addData(UserData data){
        ContentValues values=new ContentValues();
        values.put("food",data.getFood());
        values.put("category",data.getCategory());
        try {
            this.getWritableDatabase().insertOrThrow("UserData", null, values);
            Toast.makeText(context,"Sucessfully inserted data",Toast.LENGTH_SHORT).show();

        }
        catch(Exception e){
            Toast.makeText(context,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
    }
    public ArrayList<UserData> fetchData(){
        ArrayList data=new ArrayList();
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from UserData",null);
        while(cursor.moveToNext()){
            data.add(new UserData(cursor.getString(1),cursor.getString(2)));
        }
        return data;
    }

}
