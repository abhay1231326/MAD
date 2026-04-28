package com.example.Notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String CHANNEL_ID = "my_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationManager manager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                // For Android 8+
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(
                            CHANNEL_ID,
                            "My Channel",
                            NotificationManager.IMPORTANCE_DEFAULT
                    );
                    manager.createNotificationChannel(channel);
                }

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                                .setSmallIcon(android.R.drawable.ic_dialog_info) // safe icon
                                .setContentTitle("Hello!")
                                .setContentText("This is a simple notification")
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                manager.notify(1, builder.build());
            }
        });
    }
}