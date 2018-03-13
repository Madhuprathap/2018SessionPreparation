package com.madhu.linkedlist.model;

public class SingleLinkedListNode<E> extends _LinkedListNode<E>{
	private ILinkedListNode rightNode;
	
	public SingleLinkedListNode(E value) {
		this.setItem(value);
	}
	public ILinkedListNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(ILinkedListNode rightNode) {
		this.rightNode = rightNode;
	}
	
}
