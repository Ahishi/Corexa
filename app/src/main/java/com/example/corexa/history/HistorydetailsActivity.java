package com.example.corexa.history;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.corexa.R;

import java.util.List;

public class HistorydetailsActivity extends AppCompatActivity {

    List<History> Historylist = Historyglobal.getInstance().getHistorylistValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historydetails);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(HistoryActivity.EXTRA, 0);

        /* luetaan mikä verensokeri yksikkö */

        SharedPreferences prefs = this.getSharedPreferences("com.example.corexa_preferences", Context.MODE_PRIVATE);
        String yksikot = prefs.getString("yksiköt", null);

        if (yksikot.equals("1")) {
            ((TextView)findViewById(R.id.lista))
                    .setText(Historylist.get(i).getVerensokeriMmol());

        } else {
            ((TextView)findViewById(R.id.lista))
                    .setText(Historylist.get(i).getVerensokeriMG());
        }

        ((TextView)findViewById(R.id.lista2))
                .setText(Historylist.get(i).getHiilihydraatit());
        ((TextView)findViewById(R.id.lista3))
                .setText(Historylist.get(i).getInsuliinimaara());

    }

}
