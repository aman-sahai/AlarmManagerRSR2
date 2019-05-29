package com.example.alarmmanagerrsr2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String ALARM_BROADCAST
            ="com.example.alarmmanagerrsr2.alarmbroadcast";
    AlarmManager am;
    Switch aswitch;
    PendingIntent pi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am= (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent=new Intent(ALARM_BROADCAST);
        pi=PendingIntent.getBroadcast(this,100,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        final long interval_time= SystemClock.elapsedRealtime()+2*60*1000;
        final long trigger_time=1*60*1000;
        aswitch=(Switch)findViewById(R.id.switch1);
        aswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            trigger_time,interval_time,pi);
                    Toast.makeText(MainActivity.this, "Switch is on",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    am.cancel(pi);
                    Toast.makeText(MainActivity.this, "Switch is off",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
