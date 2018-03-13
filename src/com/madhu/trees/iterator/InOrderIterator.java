package com.madhu.trees.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.madhu.trees.ITree;
import com.madhu.trees.model.INode;

public class InOrderIterator<E extends INode> implements Iterator<E> {

	private Stack<E> stack = new Stack<E>();

	public InOrderIterator(ITree tree) {
		if (tree != null && tree.getRoot() != null) {
			stack.push((E) tree.getRoot());
			E temp = (E) tree.getRoot();
			while (temp.getLeftNode() != null) {
				stack.push((E) temp.getLeftNode());
			}
		}
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

//	TODO: Not accurate
	@Override
	public E next() {
		if (stack.isEmpty()) {
			return null;
		} else {
			E temp = stack.pop();
			E result = stack.pop();
			while (temp.getRightNode() != null)
				stack.push((E) temp.getRightNode());
			return result;
		}
	}
	
	@Override
	public void remove() {
		stack.pop();
	}

}
