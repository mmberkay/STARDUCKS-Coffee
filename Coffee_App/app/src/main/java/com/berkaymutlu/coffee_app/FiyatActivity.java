package com.berkaymutlu.coffee_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.berkaymutlu.coffee_app.databinding.ActivityFiyatBinding;

import java.util.ArrayList;
import java.util.Hashtable;

public class FiyatActivity extends AppCompatActivity {
    private ActivityFiyatBinding binding;
    FiyatAdapter fiyatAdapter;
    ArrayList tutucu;
    ArrayList<String> value;
    ArrayList<Integer> key;
    static Coffee coffee;
    MergeSort mergeSort;
    Hashtable<Integer,String> adapterHash;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFiyatBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        coffee = new Coffee();
        coffee.fillHashTable0();
        coffee.fillHashTable1();
        coffee.fillHashTable2();
        coffee.fillHashTable3();
        coffee.fillHashTable4();
        adapterHash = new Hashtable<>();

        binding.recyclerViewFiyat.setLayoutManager(new LinearLayoutManager(this));


        Intent intent = getIntent();
        String info = intent.getStringExtra("info");
        if (info.equals("çay")) {
            key = new ArrayList<>(coffee.hash0.keySet());
            value = new ArrayList<>(coffee.hash0.values());

            mergeSort = new MergeSort(key);
            mergeSort.getArrayAfterSorting();
            mergeSort.divideArrayElements(0,key.size()-1);

            fiyatAdapter = new FiyatAdapter(mergeSort.getArrayAfterSorting(),coffee.hash0);
            binding.recyclerViewFiyat.setAdapter(fiyatAdapter);

        } else if (info.equals("limonata")) {
            key = new ArrayList<>(coffee.hash1.keySet());
            value = new ArrayList<>(coffee.hash1.values());

            mergeSort = new MergeSort(key);
            mergeSort.getArrayAfterSorting();
            mergeSort.divideArrayElements(0,key.size()-1);

            fiyatAdapter = new FiyatAdapter(mergeSort.getArrayAfterSorting(),coffee.hash1);
            binding.recyclerViewFiyat.setAdapter(fiyatAdapter);

        } else if (info.equals("decaf")) {
            key = new ArrayList<>(coffee.hash2.keySet());
            value = new ArrayList<>(coffee.hash2.values());

            mergeSort = new MergeSort(key);
            mergeSort.getArrayAfterSorting();
            mergeSort.divideArrayElements(0,key.size()-1);

            fiyatAdapter = new FiyatAdapter(mergeSort.getArrayAfterSorting(),coffee.hash2);
            binding.recyclerViewFiyat.setAdapter(fiyatAdapter);

        } else if (info.equals("sütlü")) {
            key = new ArrayList<>(coffee.hash3.keySet());
            value = new ArrayList<>(coffee.hash3.values());

            mergeSort = new MergeSort(key);
            mergeSort.getArrayAfterSorting();
            mergeSort.divideArrayElements(0,key.size()-1);

            fiyatAdapter = new FiyatAdapter(mergeSort.getArrayAfterSorting(),coffee.hash3);
            binding.recyclerViewFiyat.setAdapter(fiyatAdapter);

        } else {
            key = new ArrayList<>(coffee.hash4.keySet());
            value = new ArrayList<>(coffee.hash4.values());

            mergeSort = new MergeSort(key);
            mergeSort.getArrayAfterSorting();
            mergeSort.divideArrayElements(0,key.size()-1);

            fiyatAdapter = new FiyatAdapter(mergeSort.getArrayAfterSorting(),coffee.hash4);
            binding.recyclerViewFiyat.setAdapter(fiyatAdapter);

        }





    }

    class MergeSort {
        private ArrayList<Integer> arrayToSort;

        public MergeSort(ArrayList<Integer> arrayToSort) {
            this.arrayToSort = arrayToSort;
        }

        public ArrayList<Integer> getArrayAfterSorting() {
            return arrayToSort;
        }

        public void divideArrayElements(int indexStart, int indexEnd) {

            if (indexStart < indexEnd && (indexEnd - indexStart) >= 1) {
                int middleElement = (indexEnd + indexStart) / 2;

                divideArrayElements(indexStart, middleElement);
                divideArrayElements(middleElement + 1, indexEnd);

                mergeArrayElements(indexStart, middleElement, indexEnd);
            }
        }

        public void mergeArrayElements(int indexStart, int indexMiddle, int indexEnd) {

            ArrayList<Integer> tempArray = new ArrayList<>();

            int getLeftIndex = indexStart;
            int getRightIndex = indexMiddle + 1;

            while (getLeftIndex <= indexMiddle && getRightIndex <= indexEnd) {

                if (arrayToSort.get(getLeftIndex) <= arrayToSort.get(getRightIndex)) {

                    tempArray.add(arrayToSort.get(getLeftIndex));
                    getLeftIndex++;

                } else {

                    tempArray.add(arrayToSort.get(getRightIndex));
                    getRightIndex++;

                }
            }

            while (getLeftIndex <= indexMiddle) {
                tempArray.add(arrayToSort.get(getLeftIndex));
                getLeftIndex++;
            }

            while (getRightIndex <= indexEnd) {
                tempArray.add(arrayToSort.get(getRightIndex));
                getRightIndex++;
            }


            for (int i = 0; i < tempArray.size(); indexStart++) {
                arrayToSort.set(indexStart, tempArray.get(i++));

            }
        }
    }
}