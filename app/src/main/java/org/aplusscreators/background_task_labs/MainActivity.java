package org.aplusscreators.background_task_labs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import org.aplusscreators.background_task_labs.broadcast.ContextRegisteredNetworkBroadcastReceiver;
import org.aplusscreators.background_task_labs.notifications.NotificationUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerContextBroadcast();
    }

    private void registerContextBroadcast() {
        BroadcastReceiver networkBroadcastReceiver = new ContextRegisteredNetworkBroadcastReceiver();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        MainActivity.this.registerReceiver(networkBroadcastReceiver,filter);
    }
}
