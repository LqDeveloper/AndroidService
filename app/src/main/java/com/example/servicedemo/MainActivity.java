package com.example.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    BindService.MyBind myBind;

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("BindService-Connection", "onServiceConnected");
            myBind = (BindService.MyBind) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("BindService-Connection", "onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.start);
        textView1.setOnClickListener(this);

        textView2 = findViewById(R.id.bind);
        textView2.setOnClickListener(this);

        textView3 = findViewById(R.id.intent);
        textView3.setOnClickListener(this);

        textView4 = findViewById(R.id.receiver);
        textView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.start:
                intent = new Intent(MainActivity.this, StartService.class);
                startService(intent);
//                stopService(intent);

                break;
            case R.id.bind:
                intent = new Intent(MainActivity.this, BindService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
//                unbindService(serviceConnection);
//                myBind.print();
                break;
            case R.id.intent:
                intent = new Intent(MainActivity.this, MyIntentService.class);
                startService(intent);
                break;
            case R.id.receiver:
                intent = new Intent();
                intent.setAction("myreceiver");
                intent.setPackage("com.example.servicedemo");
                intent.putExtra("msg","这是广播的消息");
                sendOrderedBroadcast(intent,null);
                break;
        }
    }
}
