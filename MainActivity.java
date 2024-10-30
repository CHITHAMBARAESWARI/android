package com.example.studentattendance;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    ListView listView;
    ArrayList<Student> studentList;
    AttendanceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);
        listView = findViewById(R.id.listView);
        Button addStudentBtn = findViewById(R.id.btnAddStudent);

        studentList = new ArrayList<>();
        adapter = new AttendanceAdapter(this, studentList);
        listView.setAdapter(adapter);

        viewAll();

        addStudentBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
            startActivity(intent);
        });
    }

    public void viewAll() {
        Cursor res = myDb.getAllAttendanceData();
        if (res.getCount() == 0) {
            Toast.makeText(this, "No data found", Toast.LENGTH_LONG).show();
            return;
        }

        studentList.clear();
        while (res.moveToNext()) {
            studentList.add(new Student(res.getString(1), res.getString(2), res.getString(3)));
        }
        adapter.notifyDataSetChanged();
    }
}


