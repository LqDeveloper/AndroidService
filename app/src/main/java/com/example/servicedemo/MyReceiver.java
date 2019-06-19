package com.example.servicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"获取到Action" +intent.getAction()+"  获取到信息：" +intent.getStringExtra("msg"),Toast.LENGTH_LONG).show();
//       取消继续传播
        abortBroadcast();
    }
}
