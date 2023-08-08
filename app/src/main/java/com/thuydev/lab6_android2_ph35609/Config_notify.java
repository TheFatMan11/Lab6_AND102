package com.thuydev.lab6_android2_ph35609;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

public class Config_notify extends Application {

    public static final String ID_CHANEL = "lab6";

    private void config(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name = getString(R.string.tenchanel);
            String moTa = getString(R.string.motaChanel);

            int uuTien = NotificationManager.IMPORTANCE_DEFAULT;
            Uri chuong = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            NotificationChannel channel = new NotificationChannel(ID_CHANEL,name,uuTien);
            channel.setDescription(moTa);
            channel.setSound(chuong,attributes);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        config();
    }
}
