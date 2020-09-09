package com.example.myworkmanagerapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.concurrent.TimeUnit;

public class MyworkerClass extends Worker {
    private  static  final String uniqueWorkername="my.unique.worker";
    private static final long repeatIntervalMin = 15;
    private static final long flexIntervalMin = 10;
    public MyworkerClass(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }
    private  static PeriodicWorkRequest getOwnWorkRequest(){
        return new PeriodicWorkRequest.Builder(
                MyworkerClass.class, repeatIntervalMin, TimeUnit.MINUTES, flexIntervalMin, TimeUnit.MINUTES).build();
    }
    public  static  void enqueueSelf(){
        WorkManager.getInstance().enqueueUniquePeriodicWork(uniqueWorkername, ExistingPeriodicWorkPolicy.KEEP, getOwnWorkRequest());
    }

    //  This method is responsible for doing the work so whatever work that is needed to be performed


    @NonNull
    @Override
    public Result doWork() {
        displayNotification("My Worker", "Hey I finished my work lately ");
        return Result.success();
    }


     // generating a simple notification

    private void displayNotification(String title, String task) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("zeliot123", "zeliot_channel", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), "zeliot123")
                .setContentTitle(title)
                .setContentText(task)
                .setSmallIcon(R.mipmap.ic_launcher);
        notificationManager.notify(1, notification.build());


    }
}
