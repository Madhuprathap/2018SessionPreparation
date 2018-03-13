package com.madhu.trees.factories;

import com.madhu.trees.ITree;

public class _TreeAbstractFactory implements TreeAbstractFactory {

	// Template Pattern
	@Override
	public ITree CreateTree(String expression, ExpressoinOrder order) {
		ITree tree = null;
		if (expression.length() == 0) {
			return tree;
		} else {
			switch (order) {
			case INORDER:
				tree = buildTreeByInOderExpression(expression);
				break;
			default:
				tree = buildTree(expression);
				break;
			}
		}
		return tree;
	}

	public ITree buildTree(String expression) {
		// TODO Auto-generated method stub
		return null;
	}

	public ITree buildTreeByInOderExpression(String expression) {
		// TODO Auto-generated method stub
		return null;
	}

}
