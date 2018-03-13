package com.madhu.linkedlist.model;

public class DoubleLinkedListNode<E> extends SingleLinkedListNode<E>{
	public DoubleLinkedListNode(E value) {
		super(value);
	}

	private ILinkedListNode leftNode;

	public ILinkedListNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(ILinkedListNode leftNode) {
		this.leftNode = leftNode;
	}
}
