package com.example.corexa.history;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import com.example.corexa.Asetukset;
import com.example.corexa.MainActivity;
import com.example.corexa.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class History extends AppCompatActivity {
    public static final String EXTRA = "com.example.history.MESSAGE";
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(R.id.history);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext()
                                , Asetukset.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.history:
                        return true;

                }
                return false;
            }


        });

        /* Arin historian koodin sisältö */

        ListView listView = (ListView) findViewById(R.id.lista);
        SearchView sv = (SearchView) findViewById(R.id.search);

        /* Testausta varten */
        if (Historyglobal.getInstance().getHistorylistValues().size() == 0) {

            Historyglobal.getInstance().getHistorylistValues().add(new Historylist("aamupala"));
            Historyglobal.getInstance().getHistorylistValues().add(new Historylist("iltapala"));

        }

        /* Luodaan adapteri */
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Historyglobal.getInstance().getHistorylistValues());

        listView.setAdapter(adapter);

        /* Valitaan tietty tapahtuma listasta */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent nextActivity = new Intent(History.this, HistorydetailsActivity.class);
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

