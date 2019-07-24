package org.aplusscreators.background_task_labs.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Manifest Declared Receivers Work only in API level < 26 | Android 7 and below...
 */
public class NetworkBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = NetworkBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: " + intent.getAction() );
        Toast.makeText(context,"NetworkBroadcastReceiver " + intent.getAction(),Toast.LENGTH_LONG).show();
    }
}
