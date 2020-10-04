package com.example.corexa.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.corexa.R;

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
    public View getView(int position, View convertView, ViewGroup parent) {

        String nimi = getItem(position).getNimi();
        String paivamaara = getItem(position).getPaivamaara();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvnimi = convertView.findViewById(R.id.textView1);
        TextView tvpaivamaara = convertView.findViewById(R.id.textView2);

        tvnimi.setText(nimi);
        tvpaivamaara.setText(paivamaara);

        return convertView;
    }
}
