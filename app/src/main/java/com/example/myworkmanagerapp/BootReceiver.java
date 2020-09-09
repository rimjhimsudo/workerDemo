package com.example.myworkmanagerapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class BootReceiver extends BroadcastReceiver {
    Context context;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MYBOOT","working ");
        if( intent.getAction() == null || !intent.getAction().equals( "android.intent.action.BOOT_COMPLETED" ) )
            return;
        MyworkerClass.enqueueSelf();
        Toast.makeText(context,"started",Toast.LENGTH_LONG).show();
        //displayNotification("hello","rimjhim");

    }

    private void displayNotification(String title, String task) {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("zeliot123", "zeliot_channel", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context.getApplicationContext(), "zeliot123")
                .setContentTitle(title)
                .setContentText(task)
                .setSmallIcon(R.mipmap.ic_launcher);
        notificationManager.notify(1, notification.build());


    }
}
