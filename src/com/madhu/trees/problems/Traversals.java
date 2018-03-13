package com.madhu.trees.problems;

import java.util.Iterator;

import com.madhu.trees.ITree;
import com.madhu.trees.factories.BSTFactory;
import com.madhu.trees.factories.ExpressoinOrder;
import com.madhu.trees.factories.TreeFactory;
import com.madhu.trees.model.INode;
import com.madhu.trees.model.OrderType;
import com.madhu.trees.vistors.PrintVisitor;

public class Traversals {
	public static void main(String[] args) {
		System.out.println("----------------");
		ITree BST = TreeFactory.getTreeConstucted("BST", "123456789", ExpressoinOrder.INORDER);
		for (Iterator<INode> iterator = BST.makeIterator(OrderType.PREORDER); iterator.hasNext();) {
			iterator.next().accept(new PrintVisitor());
		}
		
		System.out.println("----------------");
		BST = TreeFactory.getTreeConstucted("BST", "123456789", ExpressoinOrder.INORDER);
		for (Object object : BST) {
			System.out.println(((INode)object).getValue());
		}
		
		System.out.println("----------------");
		BST = TreeFactory.getTreeConstucted("BST", "143598729", ExpressoinOrder.NOORDER);
		for (Iterator iterator = BST.makeIterator(OrderType.PREORDER); iterator.hasNext();) {
			INode node = (INode) iterator.next();
			System.out.println((int)node.getValue());
		}
		
		System.out.println("----------------");
	}
}
