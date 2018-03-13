package com.madhu.trees.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.madhu.trees.ITree;
import com.madhu.trees.model.INode;

public class PreOrderIterator<E extends INode> implements Iterator<E> {

	private Stack<E> stack = new Stack<E>();

	public PreOrderIterator(ITree tree) {
		if (tree != null && tree.getRoot() != null) {
			stack.push((E) tree.getRoot());
		}
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public E next() {
		if (stack.isEmpty()) {
			return null;
		} else {
			E temp = stack.pop();
			if (temp.getRightNode() != null)
				stack.push((E) temp.getRightNode());
			if (temp.getLeftNode() != null)
				stack.push((E) temp.getLeftNode());
			return temp;
		}
	}
	
	@Override
	public void remove() {
		stack.pop();
	}

}
