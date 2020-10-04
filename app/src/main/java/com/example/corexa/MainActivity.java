package com.example.corexa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.corexa.history.HistoryActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavbarView nav = new NavbarView(this, R.id.home);
        nav.navbar();

        button = (Button) findViewById(R.id.Valmis);
        button.setOnClickListener(this);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                button.setText("Tehty");

            }
        });

    }

    @Override
    public void onClick(View v) {
        button.setText("Tehty");
    }
}
