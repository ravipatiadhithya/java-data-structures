package com.adhithyaravipati.java.datastructures.list.stack;

import com.adhithyaravipati.java.datastructures.list.linkedlist.SingleLinkedList;

public class LinkedStack<E> implements Stack<E>{
	
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
	public void push(E element) {
		list.addFirst(element);
		
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

	@Override
	public E top() {
		return list.first();
	}

}
