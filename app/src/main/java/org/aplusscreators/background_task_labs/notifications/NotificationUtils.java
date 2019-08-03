package org.aplusscreators.background_task_labs.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import org.aplusscreators.background_task_labs.R;

public class NotificationUtils {

    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_ID", "name", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public static void createNotification(Context context, int notificationId, String CHANNEL_ID, String title, String content, @Nullable String bigText, @NonNull PendingIntent tapAction) {

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.image);
        Bitmap bitIconBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.image);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_action_notify)
                .setContentTitle(title)
                .setContentText(content)
                .setContentIntent(tapAction)
                .setNumber(4)
                .setStyle(new NotificationCompat.BigPictureStyle()
                    .bigPicture(bitmap)
                .bigLargeIcon(bitIconBitmap))
                .setAutoCancel(true);

//        if (bigText != null) {
//            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(bigText));
//        }

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(notificationId, builder.build());

    }
}
