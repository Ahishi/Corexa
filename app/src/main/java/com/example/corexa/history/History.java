package com.example.corexa.history;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.corexa.R;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    public static final String EXTRA = "com.example.history.MESSAGE";
    private Button searchbutton;
    private EditText searhedit;
    ListView listView;
    ArrayAdapter adapter;
    SearchView sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lista);
        sv = (SearchView) findViewById(R.id.search);

        /* Testausta varten */
        if (Historyglobal.getInstance().getHistorylistValues().size() == 0) {

            Historyglobal.getInstance().getHistorylistValues().add(new Historylist("aamupala"));
            Historyglobal.getInstance().getHistorylistValues().add(new Historylist("iltapala"));

        }

        /* Luodaan adapteri */
        adapter = new ArrayAdapter<Historylist>(this, android.R.layout.simple_list_item_1, Historyglobal.getInstance().getHistorylistValues());

        listView.setAdapter(adapter);

        /* Valitaan tietty tapahtuma listasta */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent nextActivity = new Intent(History.this, Historydetails.class);
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