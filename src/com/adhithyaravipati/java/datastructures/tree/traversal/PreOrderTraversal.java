package com.adhithyaravipati.java.datastructures.tree.traversal;

import com.adhithyaravipati.java.datastructures.model.Position;
import com.adhithyaravipati.java.datastructures.tree.BinaryTree;

public abstract class PreOrderTraversal<E> extends BinaryTreeTraversal<E> {

	public PreOrderTraversal(BinaryTree<E> binaryTree) {
		super(binaryTree);
	}
	
	public void start() {
		preOrder(binaryTree.root());
	}
	
	private void preOrder(Position<E> position) {
		performAction(position.getElement());
		preOrder(binaryTree.left(position));
		preOrder(binaryTree.right(position));
	}
	
}
