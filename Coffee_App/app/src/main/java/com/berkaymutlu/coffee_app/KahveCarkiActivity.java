package com.berkaymutlu.coffee_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.berkaymutlu.coffee_app.databinding.ActivityKahveCarkiBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class KahveCarkiActivity extends AppCompatActivity {
    private ActivityKahveCarkiBinding binding;
    private FirebaseAuth auth;
    private FirebaseStorage firebaseStorage;
    private FirebaseFirestore firebaseFirestore;
    private StorageReference storageReference;
    KahveCarki kahveCarki;
    static Coffee coffee;
    int sonuc;
    Set<Integer> keys;
    Iterator<Integer> itr;
    Enumeration<Integer> kys;
    Random myRandom;
    int[] dizi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKahveCarkiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        coffee = new Coffee();
        auth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = firebaseStorage.getReference();
        coffee.fillHediyeHash();
        /*
        keys = coffee.hediyeHash.keySet();
        itr = keys.iterator();
        kys = coffee.hediyeHash.keys();

         */



    }

    public void CarkOne(View view) {
        myRandom = new Random();
        dizi = new int[5];
        for (int i=0;i<dizi.length;i++){
            dizi[i]=myRandom.nextInt(34);
        }
        Cark bst = new Cark();
        for(int i=0; i<dizi.length;i++) {
            bst.insert(dizi[i]);
        }
        sonuc = bst.kazanan_pre();
        binding.kazanilanTextView.setText(coffee.hediyeHash.get(sonuc).toString());

    }

    public void CarkTwo(View view) {
        myRandom = new Random();
        dizi = new int[5];
        for (int i=0;i<dizi.length;i++){
            dizi[i]=myRandom.nextInt(34);
        }
        Cark bst = new Cark();
        for(int i=0; i<dizi.length;i++) {
            bst.insert(dizi[i]);
        }
        sonuc = bst.kazanan_in();
        binding.kazanilanTextView.setText(coffee.hediyeHash.get(sonuc).toString());
    }

    public void CarkThree(View view) {
        myRandom = new Random();
        dizi = new int[5];
        for (int i=0;i<dizi.length;i++){
            dizi[i]=myRandom.nextInt(34);
        }
        Cark bst = new Cark();
        for(int i=0; i<dizi.length;i++) {
            bst.insert(dizi[i]);
        }
        sonuc = bst.kazanan_post();
        binding.kazanilanTextView.setText(coffee.hediyeHash.get(sonuc).toString());
    }

    public void carkToMenu(View view) {
        Intent intent = new Intent(KahveCarkiActivity.this,AnaSayfaActivity.class);
        intent.putExtra("info",coffee.hediyeHash.get(sonuc).toString());
        startActivity(intent);
    }

    public static class Cark{
        class Node {
            int key;
            Cark.Node left, right;

            public Node(int data){
                key = data;
                left = right = null;
            }
        }
        static Cark.Node root;
        Cark(){
            root = null;
        }
        void insert(int key)  {
            root = insert_Recursive(root, key);
        }
        Cark.Node insert_Recursive(Cark.Node root, int key) {
            if (root == null) {
                root = new Cark.Node(key);
                return root;
            }
            if (key < root.key)
                root.left = insert_Recursive(root.left, key);
            else if (key > root.key)
                root.right = insert_Recursive(root.right, key);

            return root;
        }
        static int[] sonuc_post = new int[5];
        static int[] sonuc_pre = new int[5];
        static int[] sonuc_in = new int[5];

        static void postOrder(Cark.Node node, int[] sonuc_post)  {
            if (node == null)
                return;

            postOrder(node.left, sonuc_post);
            postOrder(node.right, sonuc_post);
//        System.out.print(node.key + " ");
            for (int i = 0; i<5; i++) {
                sonuc_post[i]= node.key;
            }
        }
        static void preOrder(Cark.Node node, int[] sonuc_pre)  {
            if (node == null)
                return;
//        System.out.print(node.key + " ");
            preOrder(node.left, sonuc_pre);
            preOrder(node.right, sonuc_pre);
            for (int i = 0; i<5; i++) {
                sonuc_pre[i]= node.key;
            }
        }
        static void inOrder(Cark.Node node, int[] sonuc_in)  {
            if (node == null)
                return;

            inOrder(node.left, sonuc_in);
//        System.out.print(node.key + " ");
            inOrder(node.right, sonuc_in);
            for (int i = 0; i<5; i++) {
                sonuc_in[i]= node.key;
            }

        }

        void postOrder_traversal()  {
            postOrder(root, sonuc_post);  }
        void inOrder_traversal() {
            inOrder(root, sonuc_in);   }
        void preOrder_traversal() {
            preOrder(root, sonuc_pre);  }
        public static int kazanan_post(){
            postOrder(root,sonuc_post);

            Random r = new Random();
            int secim=r.nextInt(5);
//
//       System.out.print("Kazanılan Kahve Kodu: "+ sonuc_post[secim]);

            return sonuc_post[secim];
        }

        public static int kazanan_pre(){
            preOrder(root,sonuc_pre);

            Random r = new Random();
            int secim = r.nextInt(5);
//        System.out.print("Kazanılan Kahve Kodu: "+ sonuc_pre[secim]);
            return sonuc_pre[secim];
        }

        public static int kazanan_in(){
            inOrder(root,sonuc_in);

            Random r = new Random();
            int secim=r.nextInt(5);
        System.out.print("Kazanılan Kahve Kodu: "+ sonuc_in[secim]);
            return sonuc_in[secim];
        }
    }

    public void upload(){

    }
}