package com.thuydev.lab6_android2_ph35609;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Constraints;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn_);
        Button button1 = findViewById(R.id.btn_1);
        Button button2 = findViewById(R.id.btn_2);
        Button button3 = findViewById(R.id.btn_3);
        sac();
button3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,Service_web.class);
        startService(intent);
    }
});

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Service_.class);
                startService(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Service_.class);
               stopService(intent);
            }
        });

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        thongbao();
    }
});
    }

    private void thongbao(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,Config_notify.ID_CHANEL)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Thông báo")
                .setContentText("Lab6")
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap)
                        .bigLargeIcon(null)

                )
                .setLargeIcon(bitmap)
                .setColor(Color.RED)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)== PackageManager.PERMISSION_GRANTED){
            notificationManagerCompat.notify((int)new Date().getTime(),builder.build());
        }
    }
    private void sac (){
      Constraints constraints = new Constraints.Builder().setRequiresCharging(true).build();
      WorkRequest workRequest = new OneTimeWorkRequest.Builder(Congviec.class).setConstraints(constraints).build();
      WorkManager.getInstance(MainActivity.this).enqueue(workRequest);
    }
}