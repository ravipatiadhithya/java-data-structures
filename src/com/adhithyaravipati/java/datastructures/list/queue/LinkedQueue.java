package com.adhithyaravipati.java.datastructures.list.queue;

import com.adhithyaravipati.java.datastructures.list.linkedlist.SingleLinkedList;

public class LinkedQueue<E> implements Queue<E>{
	
	private SingleLinkedList<E> list = new SingleLinkedList<>();

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void enqueue(E element) {
		list.addLast(element);
		
	}

	@Override
	public E dequeue() {
		return list.removeFirst();
	}

	@Override
	public E first() {
		return list.first();
	}
	

}
