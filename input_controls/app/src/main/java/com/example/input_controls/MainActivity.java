package com.example.input_controls;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName; // NEW

    ImageButton imageButton;
    CheckBox checkBox;
    RadioGroup radioGroup;
    ToggleButton toggleButton;
    TextView tvToggle;
    Spinner spinner;
    RatingBar ratingBar;
    ProgressBar progressBar;
    Button btnSubmit, btnAlert;

    String[] courses = {"JAVA", "PHP", "HTML"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NEW
        etName = findViewById(R.id.etName);

        imageButton = findViewById(R.id.imageButton);
        checkBox = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        toggleButton = findViewById(R.id.toggleButton);
        tvToggle = findViewById(R.id.tvToggle);
        spinner = findViewById(R.id.spinner);
        ratingBar = findViewById(R.id.ratingBar);
        progressBar = findViewById(R.id.progressBar);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnAlert = findViewById(R.id.btnAlert);

        // Spinner setup
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, courses);
        spinner.setAdapter(adapter);

        // Image Button
        imageButton.setOnClickListener(v ->
                Toast.makeText(this, "Image Button Clicked", Toast.LENGTH_SHORT).show());

        // Toggle Button
        toggleButton.setOnClickListener(v -> {
            if (toggleButton.isChecked()) {
                tvToggle.setText("Toggle is ON");
            } else {
                tvToggle.setText("Toggle is OFF");
            }
        });

        // Submit Button
        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();

            if (name.isEmpty()) {
                etName.setError("Enter name");
                return;
            }

            String check = checkBox.isChecked() ? "Checked" : "Not Checked";

            int id = radioGroup.getCheckedRadioButtonId();
            String radio = (id != -1)
                    ? ((RadioButton) findViewById(id)).getText().toString()
                    : "None";

            String course = spinner.getSelectedItem().toString();
            float rating = ratingBar.getRating();

            progressBar.setVisibility(View.VISIBLE);

            String result = "Name: " + name +
                    "\nCheckbox: " + check +
                    "\nRadio: " + radio +
                    "\nSpinner: " + course +
                    "\nRating: " + rating;

            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        });

        // Alert Dialog
        btnAlert.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alert");
            builder.setMessage("Do you want to close app?");
            builder.setPositiveButton("Yes", (dialog, which) -> finish());
            builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
            builder.show();
        });

        // Welcome Toast
        Toast.makeText(this, "Welcome to Android Program", Toast.LENGTH_SHORT).show();
    }
}