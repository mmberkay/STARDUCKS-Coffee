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
import android.widget.Toast;

import com.berkaymutlu.coffee_app.databinding.ActivityMainBinding;
import com.berkaymutlu.coffee_app.databinding.ActivityMenuBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MenuActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private ActivityMenuBinding binding;
    CoffeeAdapter coffeeAdapter;
    static Coffee coffee;
    ArrayList<String> values;
    ArrayList<Integer> keys;
    ArrayList stackArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();

            coffee = new Coffee();




        coffee.fillHashTable0();
        coffee.fillHashTable1();
        coffee.fillHashTable2();
        coffee.fillHashTable3();
        coffee.fillHashTable4();

        Intent intent = getIntent();
        String info = intent.getStringExtra("info");

        if(info.equals("Çaylar")){
            keys = new ArrayList<>(coffee.hash0.keySet());
            values = new ArrayList<>(coffee.hash0.values());
        }else if(info.equals("Limonata")){
            keys = new ArrayList<>(coffee.hash1.keySet());
            values = new ArrayList<>(coffee.hash1.values());
        }else if(info.equals("Decaf")){
            keys = new ArrayList<>(coffee.hash2.keySet());
            values = new ArrayList<>(coffee.hash2.values());
        }else if(info.equals("Sütlü Kahve")){
            keys = new ArrayList<>(coffee.hash3.keySet());
            values = new ArrayList<>(coffee.hash3.values());
        }else{
            keys = new ArrayList<>(coffee.hash4.keySet());
            values = new ArrayList<>(coffee.hash4.values());
        }



//        kahveArryList.addAll(kahveCollection);

        binding.coffeeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        coffeeAdapter = new CoffeeAdapter(values,keys);
        binding.coffeeRecyclerView.setAdapter(coffeeAdapter);


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
            Intent intentToMain = new Intent(MenuActivity.this,MainActivity.class);
            startActivity(intentToMain);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}