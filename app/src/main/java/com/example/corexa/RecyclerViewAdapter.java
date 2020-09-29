package com.example.corexa;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> text1List;
    private ArrayList<String> text2List;
    private ArrayList<String> text3List;

    public RecyclerViewAdapter(ArrayList<String> text1List, ArrayList<String> text2List, ArrayList<String> text3List){
        this.text1List = text1List;
        this.text2List = text2List;
        this.text3List = text3List;
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

        holder.text1.setText(text1List.get(position));
        holder.text2.setText(text2List.get(position));
        holder.text3.setText(text3List.get(position));
    }

    @Override
    public int getItemCount() {
        return text1List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView text1;
        TextView text2;
        TextView text3;
        ConstraintLayout parentLayout;

                public ViewHolder(View itemView){
                    super(itemView);
                    text1 = itemView.findViewById(R.id.text1);
                    text2 = itemView.findViewById(R.id.text2);
                    text3 = itemView.findViewById(R.id.text3);
                    parentLayout = itemView.findViewById(R.id.parent_layout);
                }
    }
}
