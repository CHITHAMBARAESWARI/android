package com.example.studentattendance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editUsername, editPassword; // Declare the EditText fields
    Button btnLogin; // Declare the Button
    DatabaseHelper myDb; // DatabaseHelper instance

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Set the layout

        // Initialize DatabaseHelper
        myDb = new DatabaseHelper(this);

        // Initialize the EditText fields
        editUsername = findViewById(R.id.editTextUsername); // Ensure the ID matches your layout
        editPassword = findViewById(R.id.editText_password); // Ensure the ID matches your layout

        // Initialize the Button
        btnLogin = findViewById(R.id.button_login); // Ensure the ID matches your layout

        // Set onClickListener for the login button
        btnLogin.setOnClickListener(v -> {
            String username = editUsername.getText().toString();
            String password = editPassword.getText().toString();

            // Check user credentials
            if (myDb.checkUser(username, password)) {
                // Navigate to HomeActivity if credentials are valid
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // Close login activity after success
            } else {
                // Show an error message if credentials are invalid
                Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
