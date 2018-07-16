package com.adhithyaravipati.java.datastructures.heap;

import java.util.Comparator;

import com.adhithyaravipati.java.datastructures.list.queue.LinkedQueue;
import com.adhithyaravipati.java.datastructures.list.queue.Queue;
import com.adhithyaravipati.java.datastructures.model.Position;
import com.adhithyaravipati.java.datastructures.tree.BinaryTree;
import com.adhithyaravipati.java.datastructures.tree.LinkedBinaryTree;

public class MinHeap<E> {

	private BinaryTree<E> binaryTree;
	private Comparator<E> comparator;
	
	public MinHeap() {
		this.binaryTree = new LinkedBinaryTree<>();
		this.comparator = new DefaultComparator();
	}
	
	public MinHeap(Comparator<E> comparator) {
		this.binaryTree = new LinkedBinaryTree<>();
		this.comparator = comparator;
	}
	
	
	public void insert(E element) {
		if(!binaryTree.isEmpty()) {
			Position<E> unsortedPosition = addUnsortedNodeToHeap(element);
			trickleUp(unsortedPosition);
		} else {
			binaryTree.addRoot(element);
		}
	}
	
	private void trickleUp(Position<E> position) {
		if(position != null) {
			Position<E> currentPosition = position;
			Position<E> parentPosition = binaryTree.parent(position);
			
			while(parentPosition != null && comparator.compare(currentPosition.getElement(), parentPosition.getElement()) < 0) {
				E temp = currentPosition.getElement();
				currentPosition.setElement(parentPosition.getElement());
				parentPosition.setElement(temp);
				
				currentPosition = parentPosition;
				parentPosition = binaryTree.parent(parentPosition);
			}
		}
		
	}
	
	private Position<E> addUnsortedNodeToHeap(E element) {
		Queue<Position<E>> queue = new LinkedQueue<>();
		queue.enqueue(binaryTree.root());
		while(!queue.isEmpty()) {
			Position<E> currentPosition = queue.dequeue();
			if(binaryTree.left(currentPosition) != null) {
				queue.enqueue(binaryTree.left(currentPosition));
			} else {
				binaryTree.addLeft(currentPosition, element);
				return binaryTree.left(currentPosition);
			}
			
			if(binaryTree.right(currentPosition) != null) {
				queue.enqueue(binaryTree.right(currentPosition));
			} else {
				binaryTree.addRight(currentPosition, element);
				return binaryTree.right(currentPosition);
			}
		}
		
		return null;
	}
	
	public BinaryTree<E> getBinaryTree() {
		return binaryTree;
	}

	public void setBinaryTree(BinaryTree<E> binaryTree) {
		this.binaryTree = binaryTree;
	}
	
	private class DefaultComparator implements Comparator<E> {

		@Override
		public int compare(E o1, E o2) throws ClassCastException {
			return ((Comparable<E>) o1).compareTo(o2);
		}
		
	}
	
}
