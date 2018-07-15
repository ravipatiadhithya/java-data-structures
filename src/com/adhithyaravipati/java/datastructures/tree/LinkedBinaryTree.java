package com.adhithyaravipati.java.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

import com.adhithyaravipati.java.datastructures.model.Position;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
	
	protected class Node implements Position<E> {
		private E element;
		private Node left;
		private Node right;
		private Node parent;
		
		@Override
		public E getElement() {
			return this.element;
		}
		@Override
		public void setElement(E element) {
			this.element = element;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			this.parent = parent;
		}
	
	}
	
	protected Node validate(Position<E> position) throws IllegalArgumentException {
		if(position != null
				&& !(position instanceof LinkedBinaryTree.Node)) {
			throw new IllegalArgumentException("Given position does not belong to this tree");
		}
		Node treeNode = (Node) position;
		return treeNode;
	}
	
	protected Node createNode(E element, Position<E> top, Position<E> left, Position<E> right) throws IllegalArgumentException {
		Node newTreeNode = new Node();
		newTreeNode.setElement(element);
		newTreeNode.setParent(validate(top));
		newTreeNode.setLeft(validate(left));
		newTreeNode.setRight(validate(right));
		return newTreeNode;
	}
	
	private Node root;
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
	public Position<E> addRoot(E element) throws IllegalStateException {
		if(!isEmpty()) {
			throw new IllegalStateException("The tree already contains a root node");
		}
		Node newNode = createNode(element, null, null, null);
		root = newNode;
		size++;
		return root;
	}

	@Override
	public Position<E> parent(Position<E> position) throws IllegalArgumentException {
		Node treeNode = validate(position);
		return treeNode.getParent();
	}

	@Override
	public Iterable<Position<E>> getChildren(Position<E> position) throws IllegalArgumentException {
		List<Position<E>> childrenList = new ArrayList<>(2);
		if(left(position) != null) {
			childrenList.add(left(position));
		}
		if(right(position) != null) {
			childrenList.add(right(position));
		}
		return childrenList;
	}

	@Override
	public Position<E> left(Position<E> position) throws IllegalArgumentException {
		Node treeNode = validate(position);
		return treeNode.getLeft();
	}

	@Override
	public Position<E> addLeft(Position<E> position, E element) throws IllegalArgumentException, IllegalStateException {
		if(left(position) != null) {
			throw new IllegalStateException("The position already contains a left child.");
		}
	
		Node leftChild = createNode(element, position, null, null);
		
		Node parent = validate(position);
		parent.setLeft(leftChild);
		size++;
		return leftChild;
	}

	@Override
	public Position<E> right(Position<E> position) throws IllegalArgumentException {
		Node treeNode = validate(position);
		return treeNode.getRight();
	}

	@Override
	public Position<E> addRight(Position<E> position, E element) throws IllegalArgumentException {
		if(right(position) !=  null) {
			throw new IllegalStateException("The position already contains a right child");
		}
		
		Node rightChild = createNode(element, position, null, null);
		
		Node parent = validate(position);
		parent.setRight(rightChild);
		size++;
		return rightChild;
	}

	@Override
	public Position<E> sibling(Position<E> position) throws IllegalArgumentException {
		Node treeNode = validate(position);
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

	@Override
	public int height(Position<E> position) {
		int height = 0;
		for(Position<E> child : getChildren(position)) {
			height = Math.max(height, 1 + height(child));
		}
		return height;
	}

	@Override
	public int depth(Position<E> position) {
		if(position == root()) {
			return 0;
		} else {
			Node treeNode = validate(position);
			return 1 + depth(parent(treeNode));
		}
	}

}
