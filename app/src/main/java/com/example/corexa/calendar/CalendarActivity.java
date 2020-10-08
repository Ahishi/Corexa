package com.example.corexa.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.corexa.NavbarView;
import com.example.corexa.R;
import com.example.corexa.history.History;
import com.example.corexa.history.HistoryActivity;
import com.example.corexa.history.Historyglobal;

import java.util.ArrayList;
import java.util.List;

public class CalendarActivity extends AppCompatActivity {
    private static final String TAG = "CalendarActivity";

    List<History> historyList;
    InCalendarList arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Log.d(TAG, "onCreate: started.");

        HistoryListHandler historyListHandler = new HistoryListHandler(Historyglobal.getInstance().getHistorylistValues());

        arrayAdapter = new InCalendarList(this,R.layout.layout_listview_item,  historyListHandler.getModelForList());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavbarView nav = new NavbarView(this, R.id.history);
        nav.navbar();

        handleHistoryList();
        initTexts();
        initRecyclerView();
    }

    private void handleHistoryList(){
        historyList = Historyglobal.getInstance().getHistorylistValues();
    }

    private void initTexts(){
        Log.d(TAG, "preparing texts.");

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(arrayAdapter);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.history_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item1){
            startActivity(new Intent(getApplicationContext()
                    , HistoryActivity.class));
            overridePendingTransition(0, 0);
            return true;
        } else {
            return true;
        }
    }
}
