package com.example.studentattendance;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editDate, editStatus;
    Button btnAddData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.editText_name);
        editDate = findViewById(R.id.editText_date);
        editStatus = findViewById(R.id.editText_status);
        btnAddData = findViewById(R.id.button_add);

        btnAddData.setOnClickListener(v -> {
            boolean isInserted = myDb.insertAttendanceData(editName.getText().toString(), editDate.getText().toString(), editStatus.getText().toString());

            if (isInserted)
                Toast.makeText(AddStudentActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(AddStudentActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
        });
    }
}

