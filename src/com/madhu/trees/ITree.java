package com.madhu.trees;

import java.util.Iterator;

import com.madhu.trees.model.INode;
import com.madhu.trees.model.OrderType;

public interface ITree extends Iterable{
	INode getRoot();
	void setRoot(INode node);
	INode addNode(INode node);
	INode removeNode(INode node);
	Iterator makeIterator(OrderType orderType);
}
