package org.aplusscreators.background_task_labs.broadcast;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import org.aplusscreators.background_task_labs.MainActivity;
import org.aplusscreators.background_task_labs.notifications.NotificationUtils;

import java.util.Random;


/**
 * Context Registered Broadcast Receiver, supported in API level 26,28,29 and below to 19
 */
public class ContextRegisteredNetworkBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent tapIntent = new Intent(context,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,tapIntent,0);
        NotificationUtils.createNotificationChannel(context);
        int notification_id = new Random().nextInt();
        NotificationUtils.createNotification(context,notification_id,"CHANNEL_ID","Notification Title","This is a notification","This is more information on this notification",pendingIntent);

        Toast.makeText(context,"ContextRegisteredNetworkBroadcastReceiver " + intent.getAction(),Toast.LENGTH_LONG).show();
    }
}
