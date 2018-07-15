package com.adhithyaravipati.java.datastructures.model;

public interface Entry<K, V> {
	
	K getKey();
	
	void setKey(K key);
	
	V getValue();
	
	void setValue(V value);
	
}
