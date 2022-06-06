package com.berkaymutlu.coffee_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.berkaymutlu.coffee_app.databinding.RecyclerRowBinding;

import java.util.ArrayList;
import java.util.Hashtable;

public class FiyatAdapter extends RecyclerView.Adapter<FiyatAdapter.FiyatHolder> {

    private ArrayList<Integer> integerArrayList;
    Hashtable<Integer,String> adapterHash;


    public FiyatAdapter(ArrayList<Integer> integerArrayList, Hashtable<Integer, String> adapterHash) {
        this.integerArrayList = integerArrayList;
        this.adapterHash = adapterHash;
    }

    @NonNull
    @Override
    public FiyatAdapter.FiyatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new FiyatHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FiyatAdapter.FiyatHolder holder, int position) {
        holder.recyclerRowBinding.recyclerViewCostTextView.setText(integerArrayList.get(position).toString()+"₺");
        holder.recyclerRowBinding.recyclerViewCoffeeTextView.setText(adapterHash.get(integerArrayList.get(position)));

    }

    @Override
    public int getItemCount() {
        return integerArrayList.size();
    }

    class FiyatHolder extends RecyclerView.ViewHolder {
        RecyclerRowBinding recyclerRowBinding;
        public FiyatHolder(@NonNull RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }
}
