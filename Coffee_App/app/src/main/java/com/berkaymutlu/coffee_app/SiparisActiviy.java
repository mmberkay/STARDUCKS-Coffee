package com.berkaymutlu.coffee_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.berkaymutlu.coffee_app.databinding.ActivitySiparisActiviyBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class SiparisActiviy extends AppCompatActivity {
    private ActivitySiparisActiviyBinding binding;
    private FirebaseAuth auth;
    private FirebaseStorage firebaseStorage;
    private FirebaseFirestore firebaseFirestore;
    private StorageReference storageReference;
    String info;
    static ArrayList<String> siparisArrayList;
    CoffeeStack coffeeStack;
    Queue queue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySiparisActiviyBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        queue = new LinkedList();
        siparisArrayList = new ArrayList();

        auth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = firebaseStorage.getReference();

        Intent intent = getIntent();
        info = intent.getStringExtra("info");
        binding.siparisTextView.setText("Sipariş Edilen Kahve:"+info);




    }

    public void order(View view)  {
        Toast.makeText(SiparisActiviy.this,"Siparişiniz hazırlanıyor. Lütfen bekleyin.",Toast.LENGTH_SHORT).show();
        uploadData();

    }

    public void uploadData(){
        String email = auth.getCurrentUser().getEmail();

        HashMap<String,String> siparisData = new HashMap<>();
        siparisData.put("kahve",info);


        firebaseFirestore.collection("Users").document(email).set(siparisData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                DocumentReference documentReference = firebaseFirestore.collection("Users").document(email);
                documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot snapshot = task.getResult();
                            if(snapshot.exists()){
                                Map<String,Object> data = snapshot.getData();
                                String value =(String) data.get("kahve");
                                coffeeStack.stack.push(value);



                            }
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SiparisActiviy.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });




    }

    public void goMenu(View view) {
        Intent intent = new Intent(SiparisActiviy.this,FirstMenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void showOrder(View view) {
        String email = auth.getCurrentUser().getEmail();

                    /*    for(int i = 0;i< CoffeeStack.stack.size();i++){
                            siparisArrayList.add(CoffeeStack.stack.pop().toString());
                        }*/

        Iterator iterator = CoffeeStack.stack.iterator();
                        while (iterator.hasNext()){
                            siparisArrayList.add(iterator.next().toString());

                        }

//                        CoffeeStack.stack.clear();



        Intent intent = new Intent(SiparisActiviy.this,OrderListActivity.class);

        startActivity(intent);
                    }
    public void timer(){
        queue.offer(coffeeStack.stack.peek());
        String string = queue.poll().toString();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Toast.makeText(SiparisActiviy.this,string+" siparişiniz yola çıktı", Toast.LENGTH_SHORT).show();
                if(!queue.isEmpty()){
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,5000,5000);

    }





}