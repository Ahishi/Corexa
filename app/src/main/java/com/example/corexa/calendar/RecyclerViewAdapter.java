package com.example.corexa.calendar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corexa.R;
import com.example.corexa.history.History;
import com.example.corexa.history.Historyglobal;
import com.example.corexa.history.Historylist;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayAdapter arrayAdapter;

    public RecyclerViewAdapter(ArrayAdapter arrayAdapter){
        this.arrayAdapter = arrayAdapter;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        List<History> historyList = Historyglobal.getInstance().getHistorylistValues();
        String str = historyList.get(0).getPaivamaara();
        holder.date.setText("8.10.");
    }

    @Override
    public int getItemCount() {
        HistoryListHandler historyListHandler = new HistoryListHandler(Historyglobal.getInstance().getHistorylistValues());
        return historyListHandler.getDays();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ListView listView;
        TextView date;
        TextView year;

        ConstraintLayout parentLayout;

                public ViewHolder(View itemView){
                    super(itemView);

                    date = itemView.findViewById(R.id.date);
                    year = itemView.findViewById(R.id.year);


                    listView = itemView.findViewById(R.id.list_view);

                    listView.setAdapter(arrayAdapter);

                    parentLayout = itemView.findViewById(R.id.parent_layout);
                }
    }
}
