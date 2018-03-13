package com.madhu.linkedlist.factory;

import com.madhu.linkedlist.ILinkedList;
import com.madhu.linkedlist.SingleLinkedList;
import com.madhu.linkedlist.model.ILinkedListNode;

public class SingleLinkedListFactory<E extends ILinkedList<I>, I> extends _ListFactory<E> {

	@Override
	public E createList(String list) {
		SingleLinkedList<ILinkedListNode<Integer>, Integer> singleList = new SingleLinkedList<>();
		NodeFactory<Integer> nodeFactory = new NodeFactory<>();
		String[] l = list.split("->");
		for (String ll : l) {
			ILinkedListNode<Integer> node = nodeFactory.getNode("single", Integer.parseInt(ll));
			singleList.addNode(node);
		}
		return (E) singleList;
	}

}
