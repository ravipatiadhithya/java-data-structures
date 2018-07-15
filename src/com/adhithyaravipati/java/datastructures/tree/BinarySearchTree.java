package com.adhithyaravipati.java.datastructures.tree;

import java.util.Comparator;

import com.adhithyaravipati.java.datastructures.model.Position;

public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {
	
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

	@Override
	public boolean isEmpty() {
		return binaryTree.isEmpty();
	}

	@Override
	public int size() {
		return binaryTree.size();
	}

	@Override
	public boolean isRoot(Position<E> position) throws IllegalArgumentException {
		return binaryTree.isRoot(position);
	}

	@Override
	public boolean isInternal(Position<E> position) throws IllegalArgumentException {
		return binaryTree.isInternal(position);
	}

	@Override
	public boolean isExternal(Position<E> position) throws IllegalArgumentException {
		return binaryTree.isExternal(position);
	}

	@Override
	public int numOfChildren(Position<E> position) throws IllegalArgumentException {
		return binaryTree.numOfChildren(position);
	}

	@Override
	public Position<E> root() {
		return binaryTree.root();
	}

	@Override
	public Position<E> addRoot(E element) throws IllegalStateException {
		return binaryTree.addRoot(element);
	}

	@Override
	public Position<E> parent(Position<E> position) throws IllegalArgumentException {
		return binaryTree.parent(position);
	}

	@Override
	public Iterable<Position<E>> getChildren(Position<E> position) throws IllegalArgumentException {
		return binaryTree.getChildren(position);
	}

	@Override
	public Position<E> left(Position<E> position) throws IllegalArgumentException {
		return binaryTree.left(position);
	}

	@Override
	public Position<E> addLeft(Position<E> position, E element) throws IllegalArgumentException, IllegalStateException {
		return binaryTree.addLeft(position, element);
	}

	@Override
	public Position<E> right(Position<E> position) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return binaryTree.right(position);
	}

	@Override
	public Position<E> addRight(Position<E> position, E element)
			throws IllegalArgumentException, IllegalStateException {
		return binaryTree.addRight(position, element);
	}

	@Override
	public Position<E> sibling(Position<E> position) throws IllegalArgumentException {
		return binaryTree.sibling(position);
	}

	@Override
	public int height(Position<E> position) {
		return binaryTree.height(position);
	}

	@Override
	public int depth(Position<E> position) {
		return binaryTree.depth(position);
	}
 
}
