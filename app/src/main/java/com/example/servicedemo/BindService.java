package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BindService extends Service {
    public BindService() {
    }

    public class MyBind extends Binder {
        public MyBind() {
            super();
        }

        public void print() {
            Log.e("BindService-MyBind", "这是Bind");
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.e("BindService", "onBind");
        return new MyBind();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("BindService", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("BindService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("BindService", "onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("BindService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e("BindService", "onUnbind");
        super.onRebind(intent);
    }
}
