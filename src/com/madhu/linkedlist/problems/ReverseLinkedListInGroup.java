package com.madhu.linkedlist.problems;

import java.util.Scanner;

import com.madhu.linkedlist.SingleLinkedList;
import com.madhu.linkedlist.factory.IListFactory;
import com.madhu.linkedlist.factory.ListFactory;
import com.madhu.linkedlist.model.SingleLinkedListNode;

public class ReverseLinkedListInGroup {
	public static void main(String[] args) {
		System.out.println("Enter Group:");
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		
		IListFactory<SingleLinkedList<SingleLinkedListNode<Integer>, Integer>> singleFactory = 
				(new ListFactory<SingleLinkedList<SingleLinkedListNode<Integer>, Integer>, SingleLinkedListNode<Integer>>()).getFactory("single");
		SingleLinkedList<SingleLinkedListNode<Integer>, Integer> list = singleFactory.createList("1->2->3->4->5->6->7->8");
		SingleLinkedListNode<Integer>  reversed = null;
		try {
			 reversed = reverseInGroup(list.getRoot(), k);
		} catch (Exception e) {
			
		}
		while(reversed != null) {
			System.out.print(reversed.getItem() + "->");
			reversed =  (SingleLinkedListNode<Integer>) reversed.getRightNode();
		}
	}

	private static SingleLinkedListNode<Integer> reverseInGroup(
			SingleLinkedListNode<Integer> root, int k) {
		SingleLinkedListNode<Integer> current = root;
		SingleLinkedListNode<Integer> next = null;
		SingleLinkedListNode<Integer> prev = null;
		int count = 0;
		
		//reverse k nodes
		while (count < k && current !=null) {
			next = (SingleLinkedListNode<Integer>) current.getRightNode();
			current.setRightNode(prev);
			prev = current;
			current = next;
			count ++;
		}
		
		if (next != null) {
			root.setRightNode(reverseInGroup(next, k));
		}
		
		return prev;
	}
}
