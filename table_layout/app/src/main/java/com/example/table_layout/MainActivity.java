package com.example.table_layout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText firstName, lastName;
    RatingBar ratingBar;
    Button submitBtn;
    TextView currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        ratingBar = findViewById(R.id.ratingBar);
        submitBtn = findViewById(R.id.submitBtn);
        currentTime = findViewById(R.id.currentTime);

        // Get current system time
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String time = sdf.format(new Date());
        currentTime.setText(time);

        submitBtn.setOnClickListener(v -> {
            String fName = firstName.getText().toString();
            String lName = lastName.getText().toString();
            float rating = ratingBar.getRating();

            Toast.makeText(this,
                    "Name: " + fName + " " + lName +
                            "\nRating: " + rating,
                    Toast.LENGTH_LONG).show();
        });
    }
}
