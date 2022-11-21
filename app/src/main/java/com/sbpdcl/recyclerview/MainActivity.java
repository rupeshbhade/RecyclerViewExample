package com.sbpdcl.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<StudentModel> myList = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        adapter = new RecyclerViewAdapter(this, myList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        StudentModel studentModel = new StudentModel();
        studentModel.name = "Ram";
        studentModel.stu_class = "1 BCA";

        myList.add(studentModel);
        myList.add(studentModel);
        myList.add(studentModel);
        myList.add(studentModel);
        myList.add(studentModel);
        myList.add(studentModel);

        adapter.notifyDataSetChanged();
    }
}