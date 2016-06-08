package com.fission.sample.broadcastreceiverexample;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by lakshmi on 7/6/16.
 */
public class MyReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {


      //  Log.e("wifi","w5555555555555555555555"+intent.getExtras().getString("name"));

        ConnectivityManager connManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        Toast.makeText(context,"wifi Manager",Toast.LENGTH_SHORT).show();

        if(mWifi.isConnected()){
            String wifi = intent.getExtras().getString("wifi");
            Toast.makeText(context,"wificonnected",Toast.LENGTH_SHORT).show();
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.index)
                .setContentTitle("My notification")
                .setContentText(wifi);
        NotificationManager mNotificationManager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(0, mBuilder.build());

        }
        else{
            String notWifi = intent.getExtras().getString("notwifi");
            Toast.makeText(context,"wifi not connected",Toast.LENGTH_SHORT).show();
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.index)
                    .setContentTitle("My notification")
                    .setContentText(notWifi);
            NotificationManager mNotificationManager =
                    (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(0, mBuilder.build());
        }
    }

}
