package com.fission.sample.broadcastreceiverexample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by lakshmi on 7/6/16.
 */
public class MainActivity extends Activity {
    BroadcastReceiver mybroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.wifi.ACCESS_CHANGE_STATE");
        registerReceiver(new MyReceiver(),intentFilter);

        Intent intent= new Intent();
        intent.setAction("android.intent.action.wifi.ACCESS_CHANGE_STATE");
        intent.putExtra("wifi","wifiConnected");
        intent.putExtra("notwifi","wifiNotConnected");
        sendBroadcast(intent);
       /* mybroadcast = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i("[BroadcastReceiver]", "MyReceiver");

                if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
                    Log.i("[BroadcastReceiver]", "Screen ON");
                    Toast.makeText(context,"powerconnected",Toast.LENGTH_SHORT).show();
                }
                else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
                    Log.i("[BroadcastReceiver]", "Screen OFF");
                    Toast.makeText(context,"power disconnected",Toast.LENGTH_SHORT).show();
                }

            }
        };
        registerReceiver(mybroadcast, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        registerReceiver(mybroadcast, new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mybroadcast);
    }*/
}}
