package com.adhithyaravipati.java.datastructures.tree;

import com.adhithyaravipati.java.datastructures.model.Position;

public class LinkedBinaryTree<E> {
	
	protected class Node<T extends E> implements Position<T> {
		private T element;
		private Node<T> left;
		private Node<T> right;
		private Node<T> parent;
		
		@Override
		public T getElement() {
			return this.element;
		}
		@Override
		public void setElement(T element) {
			this.element = element;
		}
		public Node<T> getLeft() {
			return left;
		}
		public void setLeft(Node<T> left) {
			this.left = left;
		}
		public Node<T> getRight() {
			return right;
		}
		public void setRight(Node<T> right) {
			this.right = right;
		}
		public Node<T> getParent() {
			return parent;
		}
		public void setParent(Node<T> parent) {
			this.parent = parent;
		}
	
	}
	
	protected Node<E> validate(Position<E> position) throws IllegalArgumentException {
		if(!(position instanceof Node)) {
			throw new IllegalArgumentException("Given position does not belong to this tree");
		}
		Node<E> treeNode = (Node<E>) position;
		return treeNode;
	}

}
