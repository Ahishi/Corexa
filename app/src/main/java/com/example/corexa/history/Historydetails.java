package com.example.corexa.history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.example.corexa.R;

public class Historydetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historydetails);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(History.EXTRA, 0);

        ((TextView)findViewById(R.id.lista))
                .setText(Historyglobal.getInstance().getHistorylistValues().get(i).getName());
    }
}