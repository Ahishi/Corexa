package com.example.corexa.history;

import android.os.Bundle;
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

        ((TextView)findViewById(R.id.lista))
                .setText(Historylist.get(i).getVerensokeri());
    }

}
