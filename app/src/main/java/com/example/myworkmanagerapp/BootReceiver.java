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
   // Context context;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MYBOOT","working 1 at line17  : value"+intent.getAction().toString());
       // if(intent.getAction().equals( "android.intent.action.BOOT_COMPLETED")){}
            //Toast.makeText(context,"onReceive worked, Hey look at me.",Toast.LENGTH_LONG).show();
            //displayNotification("hello","rimjhim");
            Log.d("MYBOOT","working 2  at line23");
            NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("zeliot123", "zeliot_channel", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }
            NotificationCompat.Builder notification = new NotificationCompat.Builder(context, "zeliot123")
                    .setContentTitle("hello")
                    .setContentText("rimjhim")
                    .setSmallIcon(R.mipmap.ic_launcher);
            notificationManager.notify(1, notification.build());


        }
        }
        //MyworkerClass.enqueueSelf();



