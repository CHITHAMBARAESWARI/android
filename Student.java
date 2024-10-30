package com.example.studentattendance;

public class Student {

    private final String name;
    private final String date;
    private final String status;

    public Student(String name, String date, String status) {
        this.name = name;
        this.date = date;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}

