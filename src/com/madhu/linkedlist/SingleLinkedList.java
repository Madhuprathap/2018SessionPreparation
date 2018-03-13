package com.madhu.linkedlist;

import com.madhu.linkedlist.model.ILinkedListNode;

public class SingleLinkedList<N extends ILinkedListNode<E>, E> implements ILinkedList<N> {
	N root = null;
	
	public N getRoot() {
		return root;
	}

	public void setRoot(N root) {
		this.root = root;
	}

	@Override
	public N addNode(N node) {
		if (root == null) {
			root = node;
		} else {
			N temp = root;
			while (temp.getRightNode() != null) {
				temp = (N) temp.getRightNode();
			}
			temp.setRightNode(node);
		}
		return root;
	}

	@Override
	public N removeNodeAtEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public N removeNodeAtIndex(Integer index) {
		// TODO Auto-generated method stub
		return null;
	}

}
