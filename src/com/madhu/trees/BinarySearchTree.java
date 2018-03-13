package com.madhu.trees;

import com.madhu.trees.model.INode;

public class BinarySearchTree extends BinaryTree {
	
	@Override
	public INode addNode(INode node) {
		if (getRoot() == null) {
			setRoot(node);
		} else {
			INode temp = getRoot();
			while (temp != null) {
				if((int)node.getValue() < (int)temp.getValue()) {
					if (temp.getLeftNode() != null) {
						temp = temp.getLeftNode();
					} else {
						temp.setLeftNode(node);
						break;
					}
				} else {
					if (temp.getRightNode() != null) {
						temp = temp.getRightNode();
					} else {
						temp.setRightNode(node);
						break;
					}
				}
			}
		}
		return getRoot();
	}
}
