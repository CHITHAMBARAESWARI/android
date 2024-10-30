package com.example.studentattendance;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AttendanceDB";
    private static final String TABLE_STUDENTS = "students";
    private static final String TABLE_USERS = "users";
    private static final String COL_2 = "NAME";
    private static final String COL_3 = "ATTENDANCE_DATE";
    private static final String COL_4 = "STATUS";
    private static final String COL_USER_2 = "USERNAME";
    private static final String COL_USER_3 = "PASSWORD";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_STUDENTS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, ATTENDANCE_DATE TEXT, STATUS TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_USERS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT)");

        // Adding a default user
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USER_2, "admin");
        contentValues.put(COL_USER_3, "password");
        db.insert(TABLE_USERS, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Insert attendance data
    public boolean insertAttendanceData(String name, String date, String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, date);
        contentValues.put(COL_4, status);
        long result = db.insert(TABLE_STUDENTS, null, contentValues);
        return result != -1;
    }

    // Get all attendance data
    public Cursor getAllAttendanceData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_STUDENTS, null);
    }

    // Validate user login
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE USERNAME = ? AND PASSWORD = ?", new String[]{username, password});
        return cursor.getCount() > 0;
    }
}

