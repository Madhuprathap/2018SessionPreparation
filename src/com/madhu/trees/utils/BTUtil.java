package com.madhu.trees.utils;

import com.madhu.trees.model.INode;

public class BTUtil {
	public static int getLevelOfNode(INode root, INode node) {
		return getLevelOfNode(root, node, 1);
	}

	private static int getLevelOfNode(INode root, INode node, int level) {
		if (root == null ) {
			return 0;
		} else if ((int)root.getValue() == (int)node.getValue()) {
			return level;
		} else {
			int findLevel = 0;
			if (root.getLeftNode() != null) {
				findLevel = getLevelOfNode(root.getLeftNode(), node, level + 1);
			}
			if (findLevel == 0 && root.getRightNode() != null) {
				findLevel = getLevelOfNode(root.getRightNode(), node, level + 1);
			}
			return findLevel;
		}
	}
}
