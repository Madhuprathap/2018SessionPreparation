package com.madhu.trees.factories;

import com.madhu.trees.BinarySearchTree;
import com.madhu.trees.BinaryTree;
import com.madhu.trees.ITree;
import com.madhu.trees.model.BinaryNode;
import com.madhu.trees.model.INode;

public class BTFactory extends _TreeAbstractFactory {
	
	@Override
	public ITree buildTreeByInOderExpression(String expression) {
		ITree tree = null;
		if (this instanceof BTFactory) {
			tree = new BinaryTree();
		} else if (this instanceof BSTFactory) {
			tree = new BinarySearchTree();
		}
		tree.setRoot(buildInOderWay(expression));
		return tree;
	}
	
	public INode buildInOderWay(String expression) {
		int middleIndex = expression.length()/2;
		INode root = new BinaryNode(Integer.parseInt(Character.toString(expression.charAt(middleIndex))));
		if (middleIndex != 0 && expression.substring(0, middleIndex).length() != 0) {
			root.setLeftNode(buildInOderWay(expression.substring(0, middleIndex)));
		}
		if (middleIndex != 0 && expression.substring(middleIndex + 1).length() != 0) {
			root.setRightNode(buildInOderWay(expression.substring(middleIndex + 1)));
		}
		return root;
	}
	
	@Override
	public ITree buildTree(String expression) {
		ITree tree = null;
		if (this instanceof BSTFactory) {
			tree = new BinarySearchTree();
		} else if (this instanceof BTFactory) {
			tree = new BinaryTree();
		}
		INode root = null;
		for (int i = 0; i < expression.length(); i++) {
			root = tree.addNode(new BinaryNode(Integer.parseInt(String.valueOf(expression.charAt(i)))));
		}
		tree.setRoot(root);
		return tree;
	}
}
