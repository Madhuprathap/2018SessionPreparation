package com.madhu.trees.model;

public class BinaryNode extends UnaryNode{
	private INode leftNode;
	
	public BinaryNode(INode right, INode left, Object value) {
		super(right, value);
		leftNode = left;
	}
	
	public BinaryNode(Object value) {
		super(value);
	}
	
	public INode getLeftNode() {
		return leftNode;
	}
	
	public void setLeftNode(INode leftNode) {
		this.leftNode = leftNode;
	}
}
