package com.example.corexa;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.corexa.history.HistoryActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavbarView extends Activity {
    private static final String TAG = "NavbarView";
    private BottomNavigationView bottomNavigationView;
    private Activity inhtAct;
    private Integer navElementID;

    /**
     *
     * @param inhtAct
     * @param navElementID
     */

    //Tuodaan tiedot kustakin aktiviteetista

    public NavbarView(Activity inhtAct, Integer navElementID){
        this.inhtAct = inhtAct;
        this.navElementID = navElementID;
    }

    public void navbar(){
        bottomNavigationView = inhtAct.findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(navElementID);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            //Tutkitaan viekä painettu nappi mihinkään, vai ollaanko siellä jo.
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        if (navElementID != item.getItemId()) {
                            inhtAct.startActivity(new Intent(inhtAct.getApplicationContext()
                                    , MainActivity.class));
                            inhtAct.overridePendingTransition(0, 0);
                            Log.d(TAG, "homeActivity näytetään");
                        }
                        Log.d(TAG, "homeActivity = true");
                        return true;

                    case R.id.settings:
                        if (navElementID != item.getItemId()) {
                            inhtAct.startActivity(new Intent(inhtAct.getApplicationContext()
                                    , SettingsActivity2.class));
                            inhtAct.overridePendingTransition(0, 0);
                            Log.d(TAG, "settingsActivity näytetään");
                        }
                        Log.d(TAG, "settingsActivity = true");
                        return true;

                    case R.id.history:
                        if (navElementID != item.getItemId()) {
                            inhtAct.startActivity(new Intent(inhtAct.getApplicationContext()
                                    , HistoryActivity.class));
                            inhtAct.overridePendingTransition(0, 0);
                            Log.d(TAG, "historyActivity näytetään");
                        }
                        Log.d(TAG, "historyActivity = true");
                        return true;

                }
                return false;
            }
        });
    }
}
