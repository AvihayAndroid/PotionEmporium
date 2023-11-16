package com.example.potionemporium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Notification extends AppCompatActivity {
    private Button btn;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        et = findViewById(R.id.notifET);
        btn = findViewById(R.id.notifbtn);


    }
    public void notifbtn(View view){
        String text = et.getText().toString();
        NotificationHelper.showNotification(this,text);
    }

    public void notifbtn2(View view){
        String text = et.getText().toString();
        NotificationHelper.showNotificationBtn(this,text);
    }


}