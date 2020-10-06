package com.example.corexa;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.graphics.PorterDuff;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;

        import com.example.corexa.history.History;
        import com.example.corexa.history.Historyglobal;
        import com.google.gson.Gson;
        import com.google.gson.reflect.TypeToken;

        import java.lang.reflect.Type;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private Button button;
    private String ateriatyyppi = "Ei määritelty";
    List Historylist = Historyglobal.getInstance().getHistorylistValues();

    String date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.getDefault()).format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavbarView nav = new NavbarView(this, R.id.home);
        nav.navbar();

        button = (Button) findViewById(R.id.tallenna);
        button.setOnClickListener(this);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                button.setText("Tehty");

            }
        });

        Button buttonSave = findViewById(R.id.tallenna);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tallennetaantietoa();
            }
        });
        ladataantietoa();


        Spinner dropdown = findViewById(R.id.pudotusvalikko);

        String[] ateriat = new String[]{"Tyyppi", "Aamiainen", "Brunssi", "Lounas", "Välipala", "Päivällinen", "Illallinen", "Iltapala"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ateriat);

        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

    }



    @Override
    public void onClick(View v) {
        button.setText("Tehty");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                ateriatyyppi = "Ei määritelty";
                break;
            case 1:
                ateriatyyppi = "Aamiainen";
                break;
            case 2:
                ateriatyyppi = "Brunssi";
                break;
            case 3:
                ateriatyyppi = "Lounas";
                break;
            case 4:
                ateriatyyppi = "Välipala";
                break;
            case 5:
                ateriatyyppi = "Päivällinen";
                break;
            case 6:
                ateriatyyppi = "Illallinen";
                break;
            case 7:
                ateriatyyppi = "Iltapala";
                break;

        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // ei tapahdu mitään
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

        double tulosmmol = 0;
        double mg = 0;

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

            /* mikä verensokeri arvo yksikkö */

            SharedPreferences prefs = this.getSharedPreferences("com.example.corexa_preferences", Context.MODE_PRIVATE);
            String yksikot = prefs.getString("yksiköt", null);

            if (yksikot.equals("1")) {

                Log.d("yksikot","mmol/l");

                mg = 18 * Double.parseDouble(tulos1);

                tulosmmol = Double.parseDouble(tulos1);

            } else {

                Log.d("yksikot","mg/dl");

                tulosmmol = 1.0 * Double.parseDouble(tulos1) / 18;

                mg = Double.parseDouble(tulos1);

            }


            /* Kirjoitetaan tiedot SharedPreferencesiin */

            Historyglobal.getInstance().getHistorylistValues().add(new History(String.format("%.2f", tulosmmol), String.format("%.2f", mg), Double.parseDouble(tulos2), Double.parseDouble(tulos3), tulos4, date, ateriatyyppi));

            SharedPreferences sharedPreferences = getSharedPreferences("history", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(Historyglobal.getInstance().getHistorylistValues());
            editor.putString("arvot", json);
            editor.apply();

            verensokeri.getText().clear();
            hiilihydraatit.getText().clear();
            insuliinimaara.getText().clear();
            tapahtumanimi.getText().clear();

        }

    }

    private void ladataantietoa() {
        /* Luetaan sharedPreferences */
        SharedPreferences sharedPreferences = getSharedPreferences("history", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("arvot", null);
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
