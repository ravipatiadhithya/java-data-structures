package com.adhithyaravipati.java.datastructures.tree;

import java.util.Comparator;

import com.adhithyaravipati.java.datastructures.model.Position;

public class BinarySearchTree<E extends Comparable<E>> {
	
	private BinaryTree<E> binaryTree;
	private Comparator<E> comparator = new DefaultComparator();
	
	public BinarySearchTree() {
		this.binaryTree = new LinkedBinaryTree<>();
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this();
		this.comparator = comparator;
	}
	
	public void add(E element) {
		if(binaryTree.isEmpty()) {
			binaryTree.addRoot(element);
		} else {
			addElement(binaryTree.root(), element);
		}
	}
	
	private void addElement(Position<E> position, E element) {
		if(comparator.compare(position.getElement(), element) >= 0) {
			if(binaryTree.left(position) != null) {
				addElement(binaryTree.left(position), element);
			} else {
				binaryTree.addLeft(position, element);
			}
		} else {
			if(binaryTree.right(position) != null) {
				addElement(binaryTree.right(position), element);
			} else {
				binaryTree.addRight(position, element);
			}
		}
	}
	
	public int height() {
		return binaryTree.height(binaryTree.root());
	}
	
	public int depth() {
		return binaryTree.depth(binaryTree.root());
	}
	
	protected class DefaultComparator implements Comparator<E> {
		@Override
		public int compare(E o1, E o2) throws ClassCastException{
			return ((Comparable<E>) o1).compareTo(o2);
		}
	}
 
}
