package com.example.corexa.history;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.corexa.NavbarView;
import com.example.corexa.SettingsActivity2;
import com.example.corexa.MainActivity;
import com.example.corexa.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    public static final String EXTRA = "com.example.history.MESSAGE";

    private Historylist adapter;

    List Historylist = Historyglobal.getInstance().getHistorylistValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        NavbarView nav = new NavbarView(this, R.id.history);
        nav.navbar();

        /* Arin historian koodin sisältö */

        ListView listView = findViewById(R.id.lista);
        SearchView sv = findViewById(R.id.search);


        /* Luodaan adapteri */

        SharedPreferences prefs = this.getSharedPreferences("com.example.corexa_preferences", Context.MODE_PRIVATE);
        String yksikot = prefs.getString("yksiköt", null);


        if (Historylist.isEmpty()) {
            TextView textView = (TextView)findViewById(R.id.tekstilista);
            textView.setText("Näyttää siltä, ettet ole tallentanut vielä mitään...");
        }


        if (yksikot.equals("1") || yksikot.equals("2"))
        {
            adapter = new Historylist(this, R.layout.adapter_view_layout, Historylist);

            listView.setAdapter(adapter);

        }
        else{
            TextView textView = (TextView)findViewById(R.id.tekstilista);
            textView.setText("Et ole määrittänyt mittayksikköä asetuksista.");
        }



        /* Valitaan tietty tapahtuma listasta */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent nextActivity = new Intent(HistoryActivity.this, HistorydetailsActivity.class);
                nextActivity.putExtra(EXTRA, position);
                startActivity(nextActivity);

            }
        });


        /* haku */
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }

        });

    }

}



