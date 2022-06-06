package com.berkaymutlu.coffee_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.berkaymutlu.coffee_app.databinding.ActivityAnaSayfaBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class AnaSayfaActivity extends AppCompatActivity {
    private ActivityAnaSayfaBinding binding;
    private FirebaseAuth auth;
    private FirebaseStorage firebaseStorage;
    private FirebaseFirestore firebaseFirestore;
    private StorageReference storageReference;
    String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnaSayfaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = firebaseStorage.getReference();

        Intent intent = getIntent();
        info = intent.getStringExtra("info");

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
            Intent intentToMain = new Intent(AnaSayfaActivity.this,MainActivity.class);
            startActivity(intentToMain);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void goMenu(View view) {
        Intent intent = new Intent(AnaSayfaActivity.this,FirstMenuActivity.class);
        startActivity(intent);
    }

    public void kahveCarkı(View view) {
        Intent intent = new Intent(AnaSayfaActivity.this,KahveCarkiActivity.class);
        startActivity(intent);
    }

    public void siparisbutton(View view) {
        String email = auth.getCurrentUser().getEmail();

        Map<String,Object> data = new HashMap<>();
        data.put("hediyekahve", info);

        firebaseFirestore.collection("Users").document(email).set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                DocumentReference documentReference = firebaseFirestore.collection("Users").document(email);
                documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot snapshot = task.getResult();
                            if(snapshot.exists()){
                                Map<String,Object> value = snapshot.getData();
                                String string =(String) value.get("hediyekahve");
                                if(string.equals("no")){
                                    Toast.makeText(AnaSayfaActivity.this,"Hediye içeceğiniz bulunmamaktadır", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(AnaSayfaActivity.this,string+" hediye içeceğiniz yola çıkmıştır", Toast.LENGTH_SHORT).show();

                                }
                            }
                        }
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });





    }

    public void fiyatListele(View view) {
        Intent intent = new Intent(AnaSayfaActivity.this,FiyatMenuActivity.class);
        startActivity(intent);
    }
}