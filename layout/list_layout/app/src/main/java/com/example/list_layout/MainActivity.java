package com.example.list_layout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] operatingSystems = {
            "Android",
            "IPhone",
            "Blackberry",
            "WebOS",
            "Ubuntu",
            "Windows7",
            "Max OS X"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                operatingSystems
        );

        listView.setAdapter(adapter);
    }
}
