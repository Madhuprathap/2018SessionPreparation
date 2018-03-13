package com.madhu.trees;

import com.madhu.trees.model.INode;

public abstract class _Tree implements ITree{
	private INode root;
	
	@Override
	public INode getRoot() {
		return root;
	}
	
	@Override
	public void setRoot(INode root) {
		this.root = root;
	}
	
	@Override
	public INode addNode(INode node) {
		return null;
	}
	
	@Override
	public INode removeNode(INode node) {
		return null;
	}
}
