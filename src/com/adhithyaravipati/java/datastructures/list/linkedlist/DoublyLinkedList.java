package com.adhithyaravipati.java.datastructures.list.linkedlist;

import com.adhithyaravipati.java.datastructures.model.Position;

public class DoublyLinkedList<E> {

	protected class Node<T extends E> implements Position<T> {
		private T element;
		private Node<T> previous;
		private Node<T> next;

		public Node() {}

		public Node(T element, Node<T> previous, Node<T> next) {
			this.element = element;
			this.previous = previous;
			this.next = next;
		}

		@Override
		public T getElement() {
			return this.element;
		}

		@Override
		public void setElement(T element) {
			this.element = element;
		}

		public Node<T> getPreviousNode() {
			return this.previous;
		}

		public void setPreviousNode(Node<T> previousNode) {
			this.previous = previousNode;
		}

		public Node<T> getNextNode() {
			return this.next;
		}

		public void setNextNode(Node<T> nextNode) {
			this.next = nextNode;
		}

	}

	private Node<E> head;
	private Node<E> tail;
	private int size = 0;

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return this.size;
	}

	public void addFirst(E element) {
		Node<E> newHeadNode = new Node<>(element, null, head);
		if(isEmpty()) {
			head = tail = newHeadNode;
		} else {
			head.setPreviousNode(newHeadNode);
			head = newHeadNode;
		}
		size++;
	}

	public void addLast(E element) {
		Node<E> newTailNode = new Node<>(element, tail, null);
		if(isEmpty()) {
			head = tail = newTailNode;
		} else {
			tail.setNextNode(newTailNode);
			tail = newTailNode;
		}
		size++;
	}

	public void insertAfter(Position<E> position, E element) {
		Node<E> node = validate(position);

		if(node == tail) {
			addLast(element);
		} else {
			Node<E> currentNextNode = node.getNextNode();

			Node<E> newNextNode = new Node<>(element, node, node.next);
			currentNextNode.previous = newNextNode;
			node.next = newNextNode;
			size++;
		}

	}

	public void insertBefore(Position<E> position, E element) {
		Node<E> node = validate(position);

		if(node == head) {
			addFirst(element);
		} else {
			Node<E> currentPreviousNode = node.getPreviousNode();

			Node<E> newPreviousNode = new Node<>(element, currentPreviousNode, node);
			currentPreviousNode.next = newPreviousNode;
			node.previous = newPreviousNode;
			size++;
		}
	}

	public E set(Position<E> position, E element) {
		Node<E> node = validate(position);
		E oldElement = node.getElement();
		node.setElement(element);
		return oldElement;
	}

	public E remove(Position<E> position) {
		Node<E> nodeToRemove = validate(position);
		if(nodeToRemove == head) {
			Node<E> nextNode = nodeToRemove.getNextNode();
			head = nextNode;
			head.setPreviousNode(null);
		} else if(nodeToRemove == tail) {
			Node<E> previousNode = nodeToRemove.getPreviousNode();
			tail = previousNode;
			tail.setNextNode(null);
		}
		size--;
		nodeToRemove.setPreviousNode(null);
		nodeToRemove.setNextNode(null);
		return nodeToRemove.getElement();
	}

	private Node<E> validate(Position<E> position) {
		if(!(position instanceof Node)) {
			throw new IllegalStateException("The position does not belong to this list");
		}
		Node<E> node = (Node<E>) position;
		return node;
	}

}
