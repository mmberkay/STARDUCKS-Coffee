package com.berkaymutlu.coffee_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.berkaymutlu.coffee_app.databinding.ActivityFirstMenuBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class FirstMenuActivity extends AppCompatActivity {
    private ActivityFirstMenuBinding binding;
    FirstMenuAdapter firstMenuAdapter;
    ArrayList<String> menuArrayList;
    private FirebaseAuth auth;
    Coffee coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstMenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();
        menuArrayList = new ArrayList<>();
        coffee = new Coffee();
        coffee.setMenuArrayList();

        menuArrayList = coffee.menuArrayList;
        System.out.println(coffee.menuArrayList);

        binding.recyclerViewMenuView.setLayoutManager(new LinearLayoutManager(this));
        firstMenuAdapter = new FirstMenuAdapter(menuArrayList);
        binding.recyclerViewMenuView.setAdapter(firstMenuAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.logout){
            auth.signOut();
            Intent intentToMain = new Intent(FirstMenuActivity.this,MainActivity.class);
            startActivity(intentToMain);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}