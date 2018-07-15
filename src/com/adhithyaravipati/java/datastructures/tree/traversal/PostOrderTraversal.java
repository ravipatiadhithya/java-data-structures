package com.adhithyaravipati.java.datastructures.tree.traversal;

import com.adhithyaravipati.java.datastructures.model.Position;
import com.adhithyaravipati.java.datastructures.tree.BinaryTree;

public abstract class PostOrderTraversal<E> extends BinaryTreeTraversal<E> {
	
	public PostOrderTraversal(BinaryTree<E> binaryTree) {
		super(binaryTree);
	}
	
	public void postOrder(Position<E> position) {
		postOrder(binaryTree.left(position));
		postOrder(binaryTree.right(position));
		performAction(position.getElement());
	}

}
