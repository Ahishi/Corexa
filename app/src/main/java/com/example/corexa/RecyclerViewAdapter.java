package com.example.corexa;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private final ArrayList<String> text1List;
    private final ArrayList<String> text2List;
    private final ArrayList<String> text3List;

    public RecyclerViewAdapter(ArrayList<String> text1List, ArrayList<String> text2List, ArrayList<String> text3List){
        this.text1List = text1List;
        this.text2List = text2List;
        this.text3List = text3List;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
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

    public static class ViewHolder extends RecyclerView.ViewHolder{

        final TextView text1;
        final TextView text2;
        final TextView text3;
        final ConstraintLayout parentLayout;

                public ViewHolder(View itemView){
                    super(itemView);
                    text1 = itemView.findViewById(R.id.text1);
                    text2 = itemView.findViewById(R.id.text2);
                    text3 = itemView.findViewById(R.id.text3);
                    parentLayout = itemView.findViewById(R.id.parent_layout);
                }
    }
}
