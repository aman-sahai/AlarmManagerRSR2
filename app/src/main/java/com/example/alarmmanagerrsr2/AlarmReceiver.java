package com.example.alarmmanagerrsr2;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    public static final String ALARM_BROADCAST
            ="com.example.alarmmanagerrsr2.alarmbroadcast";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if (action==ALARM_BROADCAST)
        {
            NotificationManager nm= (NotificationManager)
                    context.getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder=new NotificationCompat.Builder(context);
            builder.setSmallIcon(R.drawable.ic_highlight_off_black_24dp);
            builder.setContentTitle("Alarm Notification");
            builder.setContentText("This is an alarm notification");
            builder.setPriority(2);
            builder.setDefaults(Notification.DEFAULT_ALL);
            nm.notify(100,builder.build());
        }
    }
}
