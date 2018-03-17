package ipl.pramod.com.alarmexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by pramod on 24/2/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_NAME="RemainderData";
    private static String TABLE_NAME="Data";
    private static String COL_1="id";
    private static String COL_2="data";
    private static String COL_3="minute";
    public DatabaseHelper(Context context){
        super(context,DB_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+TABLE_NAME+"("+COL_1+" int,"+COL_2+" varchar(50),"+ COL_3+" int);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public void insertRemainder(RemainderModel model){
        ContentValues values=new ContentValues();
        values.put("id",model.getId());
        values.put("data",model.getData());
        values.put("minute",model.getMinute());
        try {
            getWritableDatabase().insertOrThrow(TABLE_NAME, null, values);
        }catch (Exception e){
            Log.i("insertRemainder()","cannot insert Data");
        }
    }
    public void deleteRemainder(int minute){
        getWritableDatabase().delete(TABLE_NAME, "minute="+minute,null);
    }
    public RemainderModel getData(){
        int minute= (int) TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
        Log.i("getData()", String.valueOf(minute));
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from Data where minute="+minute,null);
        if(cursor.getCount()==1){
            cursor.moveToNext();
            return new RemainderModel(cursor.getInt(0),cursor.getString(1), cursor.getInt(2));
        }
        return null;

    }

}
