package com.adhithyaravipati.java.datastructures.tree;

import com.adhithyaravipati.java.datastructures.model.Position;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
	
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
	
	protected Node<E> createNode(E element, Position<E> top, Position<E> left, Position<E> right) throws IllegalArgumentException {
		Node<E> newTreeNode = new Node<>();
		newTreeNode.setElement(element);
		newTreeNode.setParent(validate(top));
		newTreeNode.setLeft(validate(left));
		newTreeNode.setRight(validate(right));
		return newTreeNode;
	}
	
	private Node<E> root;
	private int size;

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isRoot(Position<E> position) throws IllegalArgumentException {
		return root() == position;
	}

	@Override
	public boolean isInternal(Position<E> position) throws IllegalArgumentException {
		return numOfChildren(position) > 0;
	}

	@Override
	public boolean isExternal(Position<E> position) throws IllegalArgumentException {
		return numOfChildren(position) == 0;
	}

	@Override
	public int numOfChildren(Position<E> position) throws IllegalArgumentException {
		int childCount = 0;
		if(left(position) != null) {
			childCount++;
		}
		if(right(position) != null) {
			childCount++;
		}
		return childCount;
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> position) throws IllegalArgumentException {
		Node<E> treeNode = validate(position);
		return treeNode.getParent();
	}

	@Override
	public Position<E> left(Position<E> position) throws IllegalArgumentException {
		Node<E> treeNode = validate(position);
		return treeNode.getLeft();
	}

	@Override
	public Position<E> addLeft(Position<E> position, E element) throws IllegalArgumentException, IllegalStateException {
		if(left(position) != null) {
			throw new IllegalStateException("The position already contains a left child.");
		}
	
		Node<E> leftChild = createNode(element, position, null, null);
		
		Node<E> parent = validate(position);
		parent.setLeft(leftChild);
		size++;
		return leftChild;
	}

	@Override
	public Position<E> right(Position<E> position) throws IllegalArgumentException {
		Node<E> treeNode = validate(position);
		return treeNode.getRight();
	}

	@Override
	public Position<E> addRight(Position<E> position, E element) throws IllegalArgumentException {
		if(right(position) !=  null) {
			throw new IllegalStateException("The position already contains a right child");
		}
		
		Node<E> rightChild = createNode(element, position, null, null);
		
		Node<E> parent = validate(position);
		parent.setRight(rightChild);
		size++;
		return rightChild;
	}

	@Override
	public Position<E> sibling(Position<E> position) throws IllegalArgumentException {
		Node<E> treeNode = validate(position);
		if(treeNode.getParent() == null) {
			return null;
		}
		
		if(left(treeNode.getParent()) == treeNode) {
			return right(treeNode.getParent());
		}
		
		if(right(treeNode.getParent()) == treeNode) {
			return left(treeNode.getParent());
		}
		
		return null;
		
	}

}
