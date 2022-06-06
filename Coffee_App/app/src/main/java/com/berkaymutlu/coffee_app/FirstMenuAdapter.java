package com.berkaymutlu.coffee_app;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.berkaymutlu.coffee_app.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class FirstMenuAdapter extends RecyclerView.Adapter<FirstMenuAdapter.FirstMenuHolder> {

    private ArrayList<String> menuArrayList;

    public FirstMenuAdapter(ArrayList<String> menuArrayList) {
        this.menuArrayList = menuArrayList;
    }

    @NonNull
    @Override
    public FirstMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new FirstMenuHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FirstMenuHolder holder, int position) {
        holder.recyclerRowBinding.recyclerViewCoffeeTextView.setText(menuArrayList.get(position));
        holder.recyclerRowBinding.recyclerViewCostTextView.setText("");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),MenuActivity.class);
                intent.putExtra("info",menuArrayList.get(position).toString());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }

    class FirstMenuHolder extends RecyclerView.ViewHolder{

        RecyclerRowBinding recyclerRowBinding;

        public FirstMenuHolder(@NonNull RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding=recyclerRowBinding;
        }
    }
}
