package com.madhu.linkedlist.problems;


public class NIterations {
	

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		int n = 3;
		Node root = new Node(1).setN(new Node(2).setN(new Node(3).setN(new Node(4).setN(new Node(5).setN(new Node(6).setN(new Node(7).setN(new Node(8))))))));
		root= reverseEachN(n, root);
		System.out.println("reversed linked list" + root);
	}

	private static Node reverseEachN(int n, Node root) {
		// Base case
		if (root == null || root.getN() == null) {
			return root;
		}
		int i = n;
		Node prev = null;
		Node next = root;
		while (i > 0 && next != null) {
			Node temp = next.getN();
			next.setN(prev);
			prev = next;
			next = temp;
			i--;
		}
		if (next != null) {
			root.setN(reverseEachN(n, next));
		}
		return prev;
	}
}

class Node {
	int v;
	Node n;
	public Node getN() {
		return n;
	}
	public Node setN(Node n) {
		this.n = n;
		return this;
	}
	public Node(int v) {
		super();
		this.v = v;
	}
	
}
