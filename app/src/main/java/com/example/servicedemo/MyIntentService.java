package com.example.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("MyIntentService","onHandleIntent");

        long endTime = System.currentTimeMillis() + 10 *1000;
        while (System.currentTimeMillis()<endTime){
            synchronized (this){
                try {
                    wait(endTime - System.currentTimeMillis());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyIntentService","onDestroy");
    }
}
