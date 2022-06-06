package com.berkaymutlu.coffee_app;

import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Kuyruk {
    ArrayList kuyrukArray = new ArrayList();
    public static Queue queue = new Queue() {
        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public boolean offer(Object o) {
            return false;
        }

        @Override
        public Object remove() {
            return null;
        }

        @Nullable
        @Override
        public Object poll() {
            return null;
        }

        @Override
        public Object element() {
            return null;
        }

        @Nullable
        @Override
        public Object peek() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public Object[] toArray(@NonNull Object[] objects) {
            return new Object[0];
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection collection) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection collection) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection collection) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection collection) {
            return false;
        }

        @Override
        public void clear() {
        }
    };

    public void fillQueue(String value){
        queue.offer(value);
    }

    public String pollQueue(){
        return queue.poll().toString();
    }
}
