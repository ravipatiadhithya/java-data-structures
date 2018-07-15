package com.adhithyaravipati.java.datastructures.tree;

import com.adhithyaravipati.java.datastructures.model.Position;

public interface BinaryTree<E> {
	
	boolean isEmpty();
	
	int size();
	
	boolean isRoot(Position<E> position) throws IllegalArgumentException;
	
	boolean isInternal(Position<E> position) throws IllegalArgumentException;
	
	boolean isExternal(Position<E> position) throws IllegalArgumentException;
	
	int numOfChildren(Position<E> position) throws IllegalArgumentException;
	
	Position<E> root();
	
	Position<E> parent(Position<E> position) throws IllegalArgumentException;
	
	Position<E> left(Position<E> position) throws IllegalArgumentException;
	
	void addLeft(Position<E> position, E element) throws IllegalArgumentException, IllegalStateException;
	
	Position<E> right(Position<E> position) throws IllegalArgumentException;
	
	void addRight(Position<E> position, E element) throws IllegalArgumentException, IllegalStateException;
	
	Position<E> sibling(Position<E> position) throws IllegalArgumentException;

}
