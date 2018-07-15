package com.adhithyaravipati.java.datastructures.tree.traversal;

import com.adhithyaravipati.java.datastructures.tree.BinaryTree;

abstract class BinaryTreeTraversal<E> {
	
	public abstract void performAction(E element);
	
	protected BinaryTree<E> binaryTree;
	
	public BinaryTreeTraversal(BinaryTree<E> binaryTree) {
		this.binaryTree = binaryTree;
	}

}
