package com.madhu.trees.utils;

import com.madhu.trees.model.INode;

public class BSTUtil {
	public static int getLevelOfNode(INode root, INode node) {
		if (root == null) {
			return 0;
		} else if((int)node.getValue() == (int)root.getValue()) {
			return 1;
		} else if ((int)node.getValue() < (int)root.getValue()) {
			return getLevelOfNode(root.getLeftNode(), node) + 1;
		} else {
			return getLevelOfNode(root.getRightNode(), node) + 1;
		}
	}
}
