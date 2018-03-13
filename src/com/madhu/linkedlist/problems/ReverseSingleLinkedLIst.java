package com.madhu.linkedlist.problems;

import com.madhu.linkedlist.SingleLinkedList;
import com.madhu.linkedlist.factory.IListFactory;
import com.madhu.linkedlist.factory.ListFactory;
import com.madhu.linkedlist.model.SingleLinkedListNode;

public class ReverseSingleLinkedLIst {

	public static void main(String[] args) {
		IListFactory<SingleLinkedList<SingleLinkedListNode<Integer>, Integer>> singleFactory = 
				(new ListFactory<SingleLinkedList<SingleLinkedListNode<Integer>, Integer>, SingleLinkedListNode<Integer>>()).getFactory("single");
		SingleLinkedList<SingleLinkedListNode<Integer>, Integer> list = singleFactory.createList("1->2->3->4->5");
		
		//Reversing the singlieLinkeList
		SingleLinkedListNode<Integer> first = list.getRoot();
		SingleLinkedListNode<Integer> second = (SingleLinkedListNode<Integer>) first.getRightNode();
		first.setRightNode(null);
		while (second != null) {
			SingleLinkedListNode<Integer> temp = (SingleLinkedListNode<Integer>) second.getRightNode();
			second.setRightNode(first);
			first = second;
			second = temp;
		}
		
		System.out.println(first.getRightNode().getRightNode().getItem());
	}

}
