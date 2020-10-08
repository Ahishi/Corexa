package com.example.corexa;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.example.corexa.history.Historyglobal;

public class SettingsActivity2 extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        NavbarView nav = new NavbarView(this, R.id.settings);
        nav.navbar();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();

        dialog = new Dialog(this);

        Button poisto = findViewById(R.id.poisto);
        poisto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup(v);
            }
        });
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);

        }
    }

    public void ShowPopup(View v){

        //Button buttonDelete = (Button) dialog.findViewById(R.id.yes);

        dialog.setContentView(R.layout.popupcard_view);

        dialog.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("history", 0);
                preferences.edit().remove("arvot").commit();
                Historyglobal.getInstance().getHistorylistValues().clear();
                Toast toast1 = Toast.makeText(SettingsActivity2.this,"Tiedot poistettu.",Toast.LENGTH_LONG);
                dialog.dismiss();
                toast1.show();
            }
        });

        dialog.show();
    }
}