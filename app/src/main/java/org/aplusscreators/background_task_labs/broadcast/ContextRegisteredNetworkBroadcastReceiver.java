package org.aplusscreators.background_task_labs.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


/**
 * Context Registered Broadcast Receiver, supported in API level 26,28,29 and below to 19
 */
public class ContextRegisteredNetworkBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"ContextRegisteredNetworkBroadcastReceiver " + intent.getAction(),Toast.LENGTH_LONG).show();
    }
}
