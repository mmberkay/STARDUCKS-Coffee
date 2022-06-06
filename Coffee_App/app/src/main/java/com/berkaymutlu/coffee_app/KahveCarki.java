package com.berkaymutlu.coffee_app;

import java.util.Random;

public class KahveCarki {
    /*
    class Node {
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }
    Node root;
    KahveCarki(){
        root = null;
    }
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }
    Node insert_Recursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)
            root.right = insert_Recursive(root.right, key);

        return root;
    }
    int sonuc_post[] = new int[5];
    int sonuc_pre[] = new int[5];
    int sonuc_in[] = new int[5];

    void postOrder(Node node, int [] sonuc_post)  {
        if (node == null)
            return;

        postOrder(node.left, sonuc_post);
        postOrder(node.right, sonuc_post);
//        System.out.print(node.key + " ");
        for (int i = 0; i<5; i++) {
            sonuc_post[i]= node.key;
        }
    }
    void preOrder(Node node, int [] sonuc_pre)  {
        if (node == null)
            return;
//        System.out.print(node.key + " ");
        preOrder(node.left, sonuc_pre);
        preOrder(node.right, sonuc_pre);
        for (int i = 0; i<5; i++) {
            sonuc_pre[i]= node.key;
        }
    }
    void inOrder(Node node, int [] sonuc_in)  {
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
    public int kazanan_post(){
        postOrder(root,sonuc_post);

        Random r = new Random();
        int secim=r.nextInt(5);
//
//       System.out.print("Kazanılan Kahve Kodu: "+ sonuc_post[secim]);

        return sonuc_post[secim];
    }

    public int kazanan_pre(){
        preOrder(root,sonuc_pre);

        Random r = new Random();
        int secim=r.nextInt(5);
//        System.out.print("Kazanılan Kahve Kodu: "+ sonuc_pre[secim]);
        return sonuc_pre[secim];
    }

    public int kazanan_in(){
        inOrder(root,sonuc_in);

        Random r = new Random();
        int secim=r.nextInt(5);
//        System.out.print("Kazanılan Kahve Kodu: "+ sonuc_in[secim]);
        return sonuc_in[secim];
    }

     */

}

