package com.thuydev.lab6_android2_ph35609;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class Service_ extends Service {
    public static final String ID_CHANEL = "lab66";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service đang chạy", Toast.LENGTH_SHORT).show();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,
                Config_notify.ID_CHANEL
                )
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Xin chào tôi là service")
                .setContentText("Ok tôi đang chạy nhá người dùng")
                .setColor(Color.BLUE);
        Notification notification = builder.build();
        startForeground(1,notification);
        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service đã dừng", Toast.LENGTH_SHORT).show();
    }
}
