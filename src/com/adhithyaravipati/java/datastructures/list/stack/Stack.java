package com.adhithyaravipati.java.datastructures.list.stack;

public interface Stack<E> {
	
	boolean isEmpty();
	
	int size();
	
	void push(E element);
	
	E pop();
	
	E top();
	
}
