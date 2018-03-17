package ipl.pramod.com.alarmexample;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.provider.CalendarContract;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    final Calendar calendar=Calendar.getInstance();
    Calendar calSet;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindControls();
        db=new DatabaseHelper(this);
    }
    public void bindControls(){
        editText=findViewById(R.id.data);
    }
    public void buttonListener(View view){
        switch (view.getId()){
            case R.id.timepicker:
                createTimePicker();
                //createDatePicker();
                break;
            case R.id.datepicker:
                createDatePicker();
                break;
            case R.id.set:
                if(calSet!=null) {
                    createAlarm(calSet);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please first Select time",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    public void createAlarm(Calendar cal){
        long millis=cal.getTimeInMillis();

        Log.i("createAlarm()", String.valueOf(TimeUnit.MILLISECONDS.toMinutes(millis)));
        //inserting data to database
        db.insertRemainder(new RemainderModel((int) millis,editText.getText().toString(), (int) TimeUnit.MILLISECONDS.toMinutes(millis)));
        //long millis=System.currentTimeMillis()+sec*1000;
        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent i=new Intent(this,AlarmBroadcastReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this, (int) TimeUnit.MILLISECONDS.toMinutes(millis),i,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,millis,pendingIntent);
        Toast.makeText(getApplicationContext(),"Alarm set for "+cal.getTime(),Toast.LENGTH_SHORT).show();
    }
    private void createTimePicker(){
        calSet= (Calendar) calendar.clone();
        TimePickerDialog tp=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //currHour=hourOfDay;
                //currMin=minute;
                calSet.set(Calendar.HOUR,hourOfDay);
                calSet.set(Calendar.MINUTE,minute);
                calSet.set(Calendar.MILLISECOND,0);
                calSet.set(Calendar.SECOND,0);
            }
        },calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),false);
        tp.setTitle("Set Alarm Time");
        tp.show();
        Log.i("createTimePicker()","show timepicker");
    }
    private void createDatePicker(){
        DatePickerDialog dp=new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calSet.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                        calSet.set(Calendar.MONTH,month);
                        calSet.set(Calendar.YEAR,year);
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        dp.setTitle("Set Alarm Year");
        dp.show();
    }

    public static class AlarmBroadcastReceiver extends BroadcastReceiver{
        Context context;
        int id;
        String data=null;
        @Override
        public void onReceive(Context context, Intent intent) {
            RemainderModel model=new DatabaseHelper(context).getData();
            if(model.getData()!=null) {
                Intent i = new Intent(context, ActionListener.class);
                i.putExtra("minute", model.getMinute());
                PendingIntent actionPendingIntent = PendingIntent.getBroadcast(context, Integer.parseInt(String.valueOf(model.getMinute())), i, 0);
                NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
                NotificationChannel channel;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    channel = new NotificationChannel("CHANNEL", context.getString(R.string.app_name), NotificationManager.IMPORTANCE_HIGH);
                    channel.enableVibration(true);
                    manager.createNotificationChannel(channel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                        .setAutoCancel(true)
                        .setChannelId("CHANNEL")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Alarm Example")
                        .addAction(android.R.drawable.ic_delete, "Delete", actionPendingIntent)
                        .setContentText(model.getData());

                manager.notify(1, builder.build());
                MediaPlayer mp = MediaPlayer.create(context, R.raw.alarmmedia);
                mp.start();
            }
        }

    }
    public class ActionListener extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int i= Integer.parseInt(intent.getExtras().getString("minute"));
            DatabaseHelper db=new DatabaseHelper(context);
            PendingIntent pendingIntent=PendingIntent.getBroadcast(context,i,null,PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent);
            db.deleteRemainder(i);
        }
    }
}
