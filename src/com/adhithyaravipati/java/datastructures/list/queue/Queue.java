package com.adhithyaravipati.java.datastructures.list.queue;

public interface Queue<E> {
	
	boolean isEmpty();
	
	int size();
	
	void enqueue(E element);
	
	E dequeue();
	
	E first();

}
