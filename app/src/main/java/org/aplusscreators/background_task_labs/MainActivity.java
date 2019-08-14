package org.aplusscreators.background_task_labs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.aplusscreators.background_task_labs.broadcast.ContextRegisteredNetworkBroadcastReceiver;
import org.aplusscreators.background_task_labs.broadcast.NotificationBroadcastReceiver;
import org.aplusscreators.background_task_labs.files.FileUtils;
import org.aplusscreators.background_task_labs.notifications.NotificationUtils;
import org.aplusscreators.background_task_labs.schedule.ScheduleAlarms;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button listFilesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerContextBroadcast();

        listFilesButton = findViewById(R.id.list_files_button);

        listFilesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File[] files = FileUtils.readInternalFileSystem(MainActivity.this);

                Log.e(TAG, "Files On App Dirs: " +files.length );

                for (File file : files) {
                    Log.e(TAG, "Files: " + file.getName());
                }

                FileUtils.createInternalStorageFile(MainActivity.this,"data_file_" + new Random().nextInt() + ".txt");
            }
        });
    }

    private void registerContextBroadcast() {
        MainActivity.this.registerReceiver(new NotificationBroadcastReceiver(), NotificationBroadcastReceiver.INTENT_FILTER);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ScheduleAlarms.schedulRepeatingAlarm(MainActivity.this);
    }
}
