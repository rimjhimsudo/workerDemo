package com.example.myworkmanagerapp;



import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;

import com.example.myworkmanagerapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*final OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyworkerClass.class).build();
        WorkManager.getInstance().enqueue(workRequest);*/

        // Schedule WatchDogWorker (after a fresh install we must not rely on the BootCompleteReceiver)
        MyworkerClass.enqueueSelf();
    }
}