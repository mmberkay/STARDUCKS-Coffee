package com.berkaymutlu.coffee_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.berkaymutlu.coffee_app.databinding.ActivityOrderListBinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class OrderListActivity extends AppCompatActivity {
    private ActivityOrderListBinding binding;
    ArrayList<String> orderList;
    OrderAdapter orderAdapter;
    ArrayList orderAdapterList;
    CoffeeStack coffeeStack;
    Queue queue;
    ArrayList<String> s = SiparisActiviy.siparisArrayList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        orderAdapterList = new ArrayList();
        orderList = new ArrayList();
        queue = new LinkedList();
//        orderList = (ArrayList) CoffeeStack.stack.subList(0,1).stream().collect(Collectors.toList());
        for(int i = 0; i<s.size();i++){
            orderList.add(s.get(i).toString());
            queue.offer(orderList.get(i).toString());
//            orderList.add(queue.poll().toString());
        }

        SiparisActiviy.siparisArrayList.clear();

//        orderList.add(coffeeStack.stack.peek().toString());


        if(!coffeeStack.stack.empty()){
            countTimer();


        }

        binding.recyclerViewOrderView.setLayoutManager(new LinearLayoutManager(this));
        orderAdapter = new OrderAdapter(orderList);
        binding.recyclerViewOrderView.setAdapter(orderAdapter);


    }
    public void countTimer(){
//        queue.offer(coffeeStack.stack.peek());
        while(!queue.isEmpty()){
            String string = queue.poll().toString();
            new CountDownTimer(5000,1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    Toast.makeText(OrderListActivity.this,string+" siparişiniz yola çıktı", Toast.LENGTH_SHORT).show();



                }
            }.start();
        }

    }




}