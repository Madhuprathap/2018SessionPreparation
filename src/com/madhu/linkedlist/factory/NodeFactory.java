package com.madhu.linkedlist.factory;

import com.madhu.linkedlist.model.ILinkedListNode;
import com.madhu.linkedlist.model.SingleLinkedListNode;

public class NodeFactory<E> {
	public ILinkedListNode<E> getNode(String type, E value) {
		switch (type) {
		case "single":
			return new SingleLinkedListNode<E>(value);
		default:
			return new SingleLinkedListNode<E>(value);
		}
	}
}
