package com.example.grid_layout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);


        b1.setOnClickListener(v -> showMsg("Button 1"));
        b2.setOnClickListener(v -> showMsg("Button 2"));
        b3.setOnClickListener(v -> showMsg("Button 3"));
        b4.setOnClickListener(v -> showMsg("Button 4"));

    }

    private void showMsg(String text) {
        Toast.makeText(this, text + " clicked", Toast.LENGTH_SHORT).show();
    }
}
