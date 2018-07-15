package com.adhithyaravipati.java.datastructures.tree.traversal;

import com.adhithyaravipati.java.datastructures.list.queue.LinkedQueue;
import com.adhithyaravipati.java.datastructures.list.queue.Queue;
import com.adhithyaravipati.java.datastructures.model.Position;
import com.adhithyaravipati.java.datastructures.tree.BinaryTree;

public abstract class BreadthFirstTraversal<E> extends BinaryTreeTraversal<E> {
	
	public BreadthFirstTraversal(BinaryTree<E> binaryTree) {
		super(binaryTree);
	}

	private Queue<Position<E>> queue = new LinkedQueue<>();
	
	public void start() {
		breadthFirst(binaryTree.root());
	}
	
	private void breadthFirst(Position<E> root) {
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			Position<E> positionForAction = queue.dequeue();
			if(binaryTree.left(positionForAction) != null) {
				queue.enqueue(binaryTree.left(positionForAction));
			}
			if(binaryTree.right(positionForAction) != null) {
				queue.enqueue(binaryTree.right(positionForAction));
			}
			performAction(positionForAction.getElement());
		}
	}
	
}
