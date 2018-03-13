package com.madhu.trees.factories;

import java.util.HashMap;

import com.madhu.trees.ITree;

public class TreeFactory {
	
	static HashMap<String, TreeAbstractFactory> map = new HashMap<>(); 
	
	public TreeFactory() {
		map.put("BST", new BSTFactory());
		map.put("BT", new BTFactory());
	}
	
	public static ITree getTreeConstucted(String factory, String expression, ExpressoinOrder order) {
		return map.get(factory).CreateTree(expression,order);
	}
}
