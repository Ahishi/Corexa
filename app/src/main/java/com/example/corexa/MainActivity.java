package com.example.corexa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.corexa.history.History;
import com.example.corexa.history.Historyglobal;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    List Historylist = Historyglobal.getInstance().getHistorylistValues();

    String date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.getDefault()).format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavbarView nav = new NavbarView(this, R.id.home);
        nav.navbar();

        Log.d("date", date);

        Button buttonSave = findViewById(R.id.tallenna);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tallennetaantietoa();
            }
        });
        ladataantietoa();

    }

    private void tallennetaantietoa() {

        /* Tallennetaan etusilvulta tiedot */
        EditText verensokeri = findViewById(R.id.verensokeriEdit);
        EditText hiilihydraatit = findViewById(R.id.hiilihydraatitEdit);
        EditText insuliinimaara = findViewById(R.id.insuliinimaaraEdit);
        EditText tapahtumanimi = findViewById(R.id.tapahtumanimi);

        String tulos1 = (verensokeri.getText().toString());
        String tulos2 = (hiilihydraatit.getText().toString());
        String tulos3 = (insuliinimaara.getText().toString());
        String tulos4 = (tapahtumanimi.getText().toString());

        /* resetoidaan virheiden värit */

        verensokeri.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        hiilihydraatit.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        insuliinimaara.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        tapahtumanimi.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);

        /* Virheiden tarkistus */
        if (TextUtils.isEmpty(tulos1)) {
            verensokeri.getBackground().mutate().setColorFilter(getResources().getColor(android.R.color.holo_red_light), PorterDuff.Mode.SRC_ATOP);
        }

        if (TextUtils.isEmpty(tulos2)) {
            hiilihydraatit.getBackground().mutate().setColorFilter(getResources().getColor(android.R.color.holo_red_light), PorterDuff.Mode.SRC_ATOP);
        }

        if (TextUtils.isEmpty(tulos3)) {
            insuliinimaara.getBackground().mutate().setColorFilter(getResources().getColor(android.R.color.holo_red_light), PorterDuff.Mode.SRC_ATOP);
        }

        if (TextUtils.isEmpty(tulos4)) {
            tapahtumanimi.getBackground().mutate().setColorFilter(getResources().getColor(android.R.color.holo_red_light), PorterDuff.Mode.SRC_ATOP);
        }

        if (!TextUtils.isEmpty(tulos1) && !TextUtils.isEmpty(tulos2) && !TextUtils.isEmpty(tulos3) && !TextUtils.isEmpty(tulos4)) {

            /* Kirjoitetaan tiedot SharedPreferencesiin */
            Historyglobal.getInstance().getHistorylistValues().add(new History(Integer.valueOf(tulos1), Integer.valueOf(tulos2), Integer.valueOf(tulos3), tulos4, date));

            SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(Historyglobal.getInstance().getHistorylistValues());
            editor.putString("task list", json);
            editor.apply();

            verensokeri.getText().clear();
            hiilihydraatit.getText().clear();
            insuliinimaara.getText().clear();
            tapahtumanimi.getText().clear();

        }

    }

    private void ladataantietoa() {
        /* Luetaan sharedPreferences */
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<List<History>>() {
        }.getType();

        Historylist = gson.fromJson(json, type);
        /* Tarkistetaan onko historialista olemassa */
        if (Historyglobal.getInstance().getHistorylistValues().size() == 0) {

            if (Historylist == null) {
                Historylist = new ArrayList<>();

            } else {
                Historyglobal.getInstance().getHistorylistValues().addAll(Historylist);
            }

        }

    }
}
