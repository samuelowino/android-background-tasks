package org.aplusscreators.background_task_labs.schedule;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import org.aplusscreators.background_task_labs.broadcast.NotificationBroadcastReceiver;

public class ScheduleAlarms {

    public static void schedulRepeatingAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(NotificationBroadcastReceiver.INTENT_ACTION);
        intent.putExtra(NotificationBroadcastReceiver.EXTRA_TITLE, "Scheduled Alarm");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + 5 * 1000,
                5 * 1000,
                pendingIntent);

    }

    public static void scheduleOneTimeAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(NotificationBroadcastReceiver.INTENT_ACTION);
        intent.putExtra(NotificationBroadcastReceiver.EXTRA_TITLE, "One Time Alarm");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 60 * 1000, pendingIntent);
    }
}
