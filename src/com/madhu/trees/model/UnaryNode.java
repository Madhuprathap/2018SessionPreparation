package com.madhu.trees.model;

public class UnaryNode extends _Node{
	private INode rightNode;
	private Object Value;
	
	public UnaryNode(INode right, Object value) {
		super();
		this.rightNode = right;
		this.Value = value;
	}
	
	public UnaryNode(Object value) {
		super();
		this.Value = value;
	}

	public INode getRightNode() {
		return rightNode;
	}
	
	public void setRightNode(INode right) {
		this.rightNode = right;
	}
	
	public Object getValue() {
		return Value;
	}
	
	public int getIntValue() {
		return (int)getValue();
	}
}
