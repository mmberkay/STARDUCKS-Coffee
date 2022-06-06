package com.berkaymutlu.coffee_app;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.berkaymutlu.coffee_app.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeHolder> {

    private ArrayList<String> coffeeArrayList;
    private ArrayList<Integer> priceArrayList;

    public CoffeeAdapter(ArrayList<String> coffeeArrayList, ArrayList<Integer> priceArrayList) {
        this.coffeeArrayList = coffeeArrayList;
        this.priceArrayList = priceArrayList;

    }

    @NonNull
    @Override
    public CoffeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CoffeeHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeAdapter.CoffeeHolder holder, int position) {
        holder.recyclerRowBinding.recyclerViewCoffeeTextView.setText(coffeeArrayList.get(position));
        holder.recyclerRowBinding.recyclerViewCostTextView.setText(priceArrayList.get(position).toString()+"₺");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),SiparisActiviy.class);
                intent.putExtra("info",coffeeArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return coffeeArrayList.size();
    }

    class CoffeeHolder extends RecyclerView.ViewHolder{

        RecyclerRowBinding recyclerRowBinding;

        public CoffeeHolder(@NonNull RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }
}
