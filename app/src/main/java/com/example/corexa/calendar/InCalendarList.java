package com.example.corexa.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.corexa.R;

import java.util.List;

public class InCalendarList extends ArrayAdapter<ListModel> {

    private static final String TAG = "CustomListAdapter";

    private Context mContext;
    int mResource;

    public InCalendarList(Context context, int resource, List<ListModel> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        String type = getItem(position).getType();
        String bloodsugar = getItem(position).getVerensokeri();
        String carb = getItem(position).getHiilihydraatti();
        String insulin = getItem(position).getInsuliini();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tyyppi = convertView.findViewById(R.id.tyyppiTv);

        TextView verensokeri = convertView.findViewById(R.id.verensokeriTv);
        TextView hiilihydraatti = convertView.findViewById(R.id.hiilihydraatitTv);
        TextView insuliini = convertView.findViewById(R.id.insuliiniTv);

        tyyppi.setText(type);

        verensokeri.setText(bloodsugar);
        hiilihydraatti.setText(carb);
        insuliini.setText(insulin);


        return convertView;
    }

}
