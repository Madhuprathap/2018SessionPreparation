package com.madhu.trees.model;

import com.madhu.trees.vistors.IVistor;

public abstract class _Node implements INode{
	@Override
	public Object getValue() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public INode getLeftNode() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public INode getRightNode() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setLeftNode(INode left) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setRightNode(INode right) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void accept(IVistor vistor) {
		vistor.visit(this);
	}
}
