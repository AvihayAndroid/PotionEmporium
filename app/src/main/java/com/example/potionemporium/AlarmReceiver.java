package com.example.potionemporium;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.view.WindowManager;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent ri) {
        String msg = ri.getStringExtra("msg");
        String str = ri.getStringExtra("edittext");
        NotificationHelper.showNotificationBtn(context, str);
        Toast.makeText(context, msg+" Alarm has been activated !", Toast.LENGTH_LONG).show();
    }
}