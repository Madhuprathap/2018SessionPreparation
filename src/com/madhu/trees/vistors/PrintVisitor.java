package com.madhu.trees.vistors;

import com.madhu.trees.model.INode;

public class PrintVisitor implements IVistor {

	@Override
	public void visit(INode node) {
		System.out.println(node.getValue());
	}

}
