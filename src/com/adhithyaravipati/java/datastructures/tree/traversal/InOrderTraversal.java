package com.adhithyaravipati.java.datastructures.tree.traversal;

import com.adhithyaravipati.java.datastructures.model.Position;
import com.adhithyaravipati.java.datastructures.tree.BinaryTree;

public abstract class InOrderTraversal<E> extends BinaryTreeTraversal<E> {
	
	public InOrderTraversal(BinaryTree<E> binaryTree) {
		super(binaryTree);
	}
	
	public void start() {
		inOrder(binaryTree.root());
	}
	
	private void inOrder(Position<E> position) {
		if(binaryTree.left(position) != null) {
			inOrder(binaryTree.left(position));
		}
		
		performAction(position.getElement());
		
		if(binaryTree.right(position) != null) {
			inOrder(binaryTree.right(position));
		}
	}

}
