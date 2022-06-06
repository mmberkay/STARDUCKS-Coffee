package com.berkaymutlu.coffee_app;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

public class Coffee {

	ArrayList<String> menuArrayList = new ArrayList<>();
	public void setMenuArrayList(){
		menuArrayList.add("Çaylar");
		menuArrayList.add("Limonata");
		menuArrayList.add("Decaf");
		menuArrayList.add("Sütlü Kahve");
		menuArrayList.add("Sade Kahve");
	}

	Hashtable<Integer, String> hash0 = new Hashtable<Integer, String>();
	public void fillHashTable0(){
		hash0.put(1,"Siyah Çay");
		hash0.put(5,"İngiliz Çayı");
		hash0.put(4,"Papatya Çayı");
		hash0.put(2,"Ada Çayı");
		hash0.put(7,"Ananas & Açai");
		hash0.put(3,"Yeşil Çay");
		hash0.put(6,"Beyaz Çay");
	}

	Hashtable<Integer, String> hash1= new Hashtable<Integer, String>();
	public void fillHashTable1(){
		hash1.put(13, "Limonata");
		hash1.put(15, "Çilekli Limonata");
		hash1.put(16, "Karpuzlu Limonata");
		hash1.put(17, "Naneli Limonata");
		hash1.put(20, "Berry");
		hash1.put(22, "Strawberry & Açai");
		hash1.put(25, "Mango & Orange");
	}

	Hashtable<Integer, String> hash2= new Hashtable<Integer, String>();
	public void fillHashTable2(){
		hash2.put(24, "Chocolate Cream");
		hash2.put(21, "Vanilla Cream");
		hash2.put(23, "Java Chip Cream");
		hash2.put(25, "Strawberries & Cream");
		hash2.put(26, "Mango Passion Fruit");
	}

	Hashtable<Integer, String> hash3= new Hashtable<Integer, String>();
	public void fillHashTable3(){
		hash3.put(13, "Latte");
		hash3.put(18, "Mocha");
		hash3.put(12, "Macchiato");
		hash3.put(14, "Ristretto");
		hash3.put(15, "Flat White");
		hash3.put(10, "Cappuccino");
		hash3.put(17, "White Chocolate Mocha");
		hash3.put(16, "Caramel Macchiato");
		hash3.put(11, "Frappucino");
		hash3.put(20, "Toffee Nut Latte");
		hash3.put(19, "Chai Tea Latte");
	}

	Hashtable<Integer, String> hash4= new Hashtable<Integer, String>();
	public void fillHashTable4(){
		hash4.put(9, "Filtre Kahve");
		hash4.put(10, "Cold Brew");
		hash4.put(11, "Americano");
		hash4.put(12, "Expresso");
		hash4.put(7, "Türk Kahvesi");
	}
	Hashtable<Integer,String> hediyeHash = new Hashtable<>();
	public void fillHediyeHash(){
		hediyeHash.put(0,"İngiliz çayı");
		hediyeHash.put(1,"Limonata");
		hediyeHash.put(2,"Chocolate Cream");
		hediyeHash.put(3,"Latte");
		hediyeHash.put(4,"Filtre kahve");
		hediyeHash.put(5,"Yasemin Çayı");
		hediyeHash.put(6,"Çilekli limonata");
		hediyeHash.put(7,"Vanilla Cream");
		hediyeHash.put(8,"Mocha");
		hediyeHash.put(9,"Cold Brew");
		hediyeHash.put(10,"Papatya çayı");
		hediyeHash.put(11,"Karpuzlu limonata");
		hediyeHash.put(12,"Java Chip Cream");
		hediyeHash.put(13,"Machiato");
		hediyeHash.put(14,"Americano");
		hediyeHash.put(15,"Ada Çayı");
		hediyeHash.put(16,"Naneli Limonata");
		hediyeHash.put(17,"Strawberry & Cream");
		hediyeHash.put(18,"Ristretto");
		hediyeHash.put(19,"Expresso");
		hediyeHash.put(20,"Ananas & Açai Çayı");
		hediyeHash.put(21,"Berry");
		hediyeHash.put(22,"Mango Passion Fruit");
		hediyeHash.put(23,"Flate White");
		hediyeHash.put(24,"Türk Kahvesi");
		hediyeHash.put(25,"Yeşil Çay");
		hediyeHash.put(26,"Strawberry & Açai");
		hediyeHash.put(27,"White Chocolate Mocha");
		hediyeHash.put(28,"Beyaz Çay");
		hediyeHash.put(29,"Mango & Orange");
		hediyeHash.put(30,"Caramel Macchiato");
		hediyeHash.put(31,"Cappuciono");
		hediyeHash.put(32,"Frappocino");
		hediyeHash.put(33,"Toffee Nut Latte");
		hediyeHash.put(34,"Chai Tea Latte");






	}

//	public void
	
}
