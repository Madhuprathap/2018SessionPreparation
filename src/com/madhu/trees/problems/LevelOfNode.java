package com.madhu.trees.problems;

import com.madhu.trees.ITree;
import com.madhu.trees.factories.BSTFactory;
import com.madhu.trees.factories.BTFactory;
import com.madhu.trees.factories.ExpressoinOrder;
import com.madhu.trees.factories.TreeFactory;
import com.madhu.trees.model.BinaryNode;
import com.madhu.trees.utils.BSTUtil;
import com.madhu.trees.utils.BTUtil;

public class LevelOfNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Construct binary tree
		ITree BT = TreeFactory.getTreeConstucted("BT", "123456789", ExpressoinOrder.INORDER);
		System.out.println(BTUtil.getLevelOfNode(BT.getRoot(), new BinaryNode(new Integer(3))));
		
		BT = TreeFactory.getTreeConstucted("BT", "143598729", ExpressoinOrder.NOORDER);
		System.out.println(BTUtil.getLevelOfNode(BT.getRoot(), new BinaryNode(new Integer(5))));
		
		ITree BST = TreeFactory.getTreeConstucted("BST", "123456789", ExpressoinOrder.INORDER);
		System.out.println(BSTUtil.getLevelOfNode(BST.getRoot(), new BinaryNode(5)));
		
		BST = TreeFactory.getTreeConstucted("BST", "143598729", ExpressoinOrder.NOORDER);
		System.out.println(BSTUtil.getLevelOfNode(BST.getRoot(), new BinaryNode(9)));
	}
}
