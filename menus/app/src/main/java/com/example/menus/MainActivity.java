package com.example.menus;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button popupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        popupBtn = findViewById(R.id.popupBtn);

        // Register Context Menu
        registerForContextMenu(textView);

        // Popup Menu Click
        popupBtn.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, popupBtn);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                Toast.makeText(MainActivity.this,
                        "Selected: " + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                return true;
            });

            popupMenu.show();
        });
    }

    // OPTION MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,
                "Option: " + item.getTitle(),
                Toast.LENGTH_SHORT).show();
        return true;
    }

    // CONTEXT MENU
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this,
                "Context: " + item.getTitle(),
                Toast.LENGTH_SHORT).show();
        return true;
    }
}