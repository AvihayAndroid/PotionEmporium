package com.example.potionemporium;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Notification extends AppCompatActivity {
    private Button btn;
    private EditText et;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    private int ALARM_RQST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        et = findViewById(R.id.notifET);



    }



    public void notiftime(View view) {
        openTimePickerDialog(true);
    }

    private void openTimePickerDialog(boolean is24r) {
        Calendar calendar = Calendar.getInstance();

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), is24r);
        timePickerDialog.setTitle("Choose time");
        timePickerDialog.show();
    }

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();

            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);

            if (calSet.compareTo(calNow) <= 0) {
                calSet.add(Calendar.DATE, 1);



            }
            setAlarm(calSet);
        }
    };

        public void notifbtn2(View view) {
            String text = et.getText().toString();
            NotificationHelper.showNotificationBtn(this, text);
        }

        private void setAlarm(Calendar calSet) {
            ALARM_RQST_CODE++;
            Intent intent = new Intent(this, AlarmReceiver.class);
            intent.putExtra("msg", String.valueOf(ALARM_RQST_CODE) + " TOD");
            intent.putExtra("edittext",String.valueOf(et.getText()));
            alarmIntent = PendingIntent.getBroadcast(this,
                    ALARM_RQST_CODE, intent, PendingIntent.FLAG_IMMUTABLE);
            alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
            alarmMgr.set(AlarmManager.RTC_WAKEUP,
                    calSet.getTimeInMillis(), alarmIntent);
            Toast.makeText(this, "Alarm set at "+ String.valueOf(calSet.getTime()), Toast.LENGTH_SHORT).show();
        }



}
