package com.example.corexa.history;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.corexa.NavbarView;
import com.example.corexa.R;

public class HistoryActivity extends AppCompatActivity {
    public static final String EXTRA = "com.example.history.MESSAGE";

    private Historylist adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        NavbarView nav = new NavbarView(this, R.id.history);
        nav.navbar();

        /* Arin historian koodin sisältö */

        ListView listView = findViewById(R.id.lista);
        SearchView sv = findViewById(R.id.search);

        /* Testausta varten */
        if (Historyglobal.getInstance().getHistorylistValues().size() == 0) {

            Historyglobal.getInstance().getHistorylistValues().add(new History("aamupala", "13"));
            // Historyglobal.getInstance().getHistorylistValues().add(new History("iltapala"));

        }



        /* Luodaan adapteri */
        adapter = new Historylist(this, R.layout.adapter_view_layout, Historyglobal.getInstance().getHistorylistValues());
        listView.setAdapter(adapter);

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

