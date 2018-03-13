package com.madhu.linkedlist.model;

public abstract class _LinkedListNode<E> implements ILinkedListNode<E>{
	
	private E item;
	
	@Override
	public E getItem() {
		return item;
	}
	
	public void setItem(E item) {
		this.item = item;
	}
	
	@Override
	public ILinkedListNode getLeftNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLeftNode(ILinkedListNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ILinkedListNode getRightNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRightNode(ILinkedListNode node) {
		// TODO Auto-generated method stub
		
	}
}
