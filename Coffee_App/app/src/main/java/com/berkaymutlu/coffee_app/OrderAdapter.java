package com.berkaymutlu.coffee_app;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.berkaymutlu.coffee_app.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.SiparisHolder> {

    private ArrayList<String> siparisArrayList;

    public OrderAdapter(ArrayList<String> siparisArrayList) {
        this.siparisArrayList = siparisArrayList;
    }

    @NonNull
    @Override
    public OrderAdapter.SiparisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new SiparisHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.SiparisHolder holder, int position) {
        holder.recyclerRowBinding.recyclerViewCoffeeTextView.setText((position+1)+""+siparisArrayList.get(position));
        holder.recyclerRowBinding.recyclerViewCostTextView.setText("-------");
    }

    @Override
    public int getItemCount() {
        return siparisArrayList.size();
    }

    class SiparisHolder extends RecyclerView.ViewHolder{

        RecyclerRowBinding recyclerRowBinding;

        public SiparisHolder(@NonNull RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }
}
