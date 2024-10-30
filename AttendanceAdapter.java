package com.example.studentattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AttendanceAdapter extends android.widget.BaseAdapter {

    final Context context;
    final ArrayList<Student> studentList;

    public AttendanceAdapter(Context context, ArrayList<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.student_list_item, parent, false);
        }

        TextView name = convertView.findViewById(R.id.textView_name);
        TextView date = convertView.findViewById(R.id.textView_date);
        TextView status = convertView.findViewById(R.id.textView_status);

        Student student = studentList.get(position);
        name.setText(student.getName());
        date.setText(student.getDate());
        status.setText(student.getStatus());

        return convertView;
    }
}

