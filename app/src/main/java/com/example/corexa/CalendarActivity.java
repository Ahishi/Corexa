package com.example.corexa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CalendarActivity extends AppCompatActivity {
    private static final String TAG = "CalendarActivity";

    private ArrayList<String> text1 = new ArrayList<>();
    private ArrayList<String> text2 = new ArrayList<>();
    private ArrayList<String> text3 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Log.d(TAG, "onCreate: started.");

        initTexts();
        initRecyclerView();
    }

    private void initTexts(){
        Log.d(TAG, "preparing texts.");

        text1.add("1111");
        text2.add("2221");
        text3.add("3331");

        text1.add("1112");
        text2.add("2222");
        text3.add("3332");

        text1.add("1113");
        text2.add("2223");
        text3.add("3333");

        text1.add("1114");
        text2.add("2224");
        text3.add("3334");

        text1.add("1115");
        text2.add("2225");
        text3.add("3335");
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(text1, text2, text3);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
