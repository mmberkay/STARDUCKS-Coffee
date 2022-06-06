package com.berkaymutlu.coffee_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.berkaymutlu.coffee_app.databinding.ActivityFirstMenuBinding;
import com.berkaymutlu.coffee_app.databinding.ActivityFiyatMenuBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class FiyatMenuActivity extends AppCompatActivity {
    private ActivityFiyatMenuBinding binding;
    Coffee coffee;
    ArrayList<String> value;
    ArrayList<Integer> key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFiyatMenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        coffee = new Coffee();



    }

    public void cayFiyatButton(View view) {
        Intent intent = new Intent(FiyatMenuActivity.this,FiyatActivity.class);
        intent.putExtra("info","çay");
        startActivity(intent);
    }

    public void limonataFiyatButton(View view) {
        Intent intent = new Intent(FiyatMenuActivity.this,FiyatActivity.class);
        intent.putExtra("info","limonata");
        startActivity(intent);
    }

    public void decafFiyatButton(View view) {

        Intent intent = new Intent(FiyatMenuActivity.this,FiyatActivity.class);
        intent.putExtra("info","decaf");
        startActivity(intent);
    }

    public void sutluFiyatButton(View view) {
        Intent intent = new Intent(FiyatMenuActivity.this,FiyatActivity.class);
        intent.putExtra("info","sütlü");
        startActivity(intent);
    }

    public void sadeFiyatButton(View view) {
        Intent intent = new Intent(FiyatMenuActivity.this,FiyatActivity.class);
        intent.putExtra("info","sade");
        startActivity(intent);
    }
}