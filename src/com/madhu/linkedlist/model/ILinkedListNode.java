package com.madhu.linkedlist.model;

public interface ILinkedListNode<E> {
	E getItem();
	void setItem(E item);
	ILinkedListNode getLeftNode();
	void setLeftNode(ILinkedListNode node);
	ILinkedListNode getRightNode();
	void setRightNode(ILinkedListNode node);
}
