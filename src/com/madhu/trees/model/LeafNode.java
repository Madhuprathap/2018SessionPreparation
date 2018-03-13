package com.madhu.trees.model;

public class LeafNode extends _Node{
	private Object value;
	
	@Override
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public LeafNode(Object value) {
		this.value = value;
	}
}
