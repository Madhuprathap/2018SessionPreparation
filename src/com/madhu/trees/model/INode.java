package com.madhu.trees.model;

import com.madhu.trees.vistors.IVistor;

public interface INode {
	Object getValue();
	INode getLeftNode();
	INode getRightNode();
	void setLeftNode(INode left);
	void setRightNode(INode right);
	void accept(IVistor node);
}
