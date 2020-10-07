package com.example.corexa.history;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.corexa.NavbarView;
import com.example.corexa.R;
import com.example.corexa.RecyclerViewAdapter;

import java.util.List;

public class Historylist extends ArrayAdapter<History> {

    private static final String TAG = "PersonListAdapter";

    private Context mContext;
    int mResource;



    public Historylist(Context context, int resource, List<History> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        String paivamaara = getItem(position).getPaivamaara();
        String ateriatyyppi = getItem(position).getAteriatyyppi();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);


        TextView tvateriatyyppi = convertView.findViewById(R.id.textView1);
        TextView tvpaivamaara = convertView.findViewById(R.id.textView2);

        tvpaivamaara.setText(paivamaara);
        tvateriatyyppi.setText(ateriatyyppi);


        return convertView;
    }

}


