package com.adhithyaravipati.java.datastructures.list.linkedlist;

import com.adhithyaravipati.java.datastructures.model.Position;

public class SingleLinkedList<E> {
	
	protected class Node<T extends E> implements Position<T>{
		
		private T element;
		private Node<T> next;
		
		public Node() {}
		
		public Node(T element, Node<T> next) {
			this.element = element;
			this.next = next;
		}
		
		@Override
		public T getElement() {
			return this.element;
		}
		
		@Override
		public void setElement(T element) {
			this.element = element;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
		public Node<T> getNext() {
			return this.next;
		}
		
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return size;
	}
	
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return head.getElement();
	}
	
	public E last() {
		if(isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
	
	public void addFirst(E element) {
		Node<E> newHeadNode = new Node<>(element, head);
		if(isEmpty()) {
			head = tail = newHeadNode;
		} else {
			head = newHeadNode;
		}
		size++;
	}
	
	public void addLast(E element) {
		Node<E> newTailNode = new Node<>(element, null);
		if(isEmpty()) {
			head = tail = newTailNode;
		} else {
			tail.setNext(newTailNode);
			tail = newTailNode;
		}
		size++;
	}

	
	public E removeFirst() {
		if(isEmpty()) {
			return null;
		}
		
		E elementToReturn = head.getElement();
		head = head.getNext();
		size--;
		return elementToReturn;
	}
}
