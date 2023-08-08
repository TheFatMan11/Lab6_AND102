package com.thuydev.lab6_android2_ph35609;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class Service_web extends Service {
    public static final String ID_CHANEL = "lab66";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service đang chạy", Toast.LENGTH_SHORT).show();
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Service_web.this, "Đang chuyển...", Toast.LENGTH_SHORT).show();
                    Intent dd = new Intent(Intent.ACTION_VIEW);
                    dd.setData(Uri.parse("https://caodang.fpt.edu.vn/"));
                    dd.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(dd);
                    stopSelf();
                }
            },5000);
        }catch (Exception e){


        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service đã dừng", Toast.LENGTH_SHORT).show();
    }
}
