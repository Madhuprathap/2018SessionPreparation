package com.madhu.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.madhu.trees.factories.IteratorFactory;
import com.madhu.trees.iterator.PreOrderIterator;
import com.madhu.trees.model.INode;
import com.madhu.trees.model.OrderType;

public class BinaryTree extends _Tree{
	
	/* Level Order traverse and the node
	 * @see com.madhu.trees._Tree#addNode(com.madhu.trees.model.INode)
	 */
	@Override
	public INode addNode(INode node) {
		if (getRoot() == null) {
			setRoot(node);
		} else {
			//Queue to keep tract of level
			Queue<INode> queue = new LinkedList<>();
			queue.add(getRoot());
			while (!queue.isEmpty()) {
				INode temp = queue.remove();
				if (temp.getLeftNode() == null) {
					temp.setLeftNode(node);
					break;
				} else if (temp.getRightNode() == null) {
					temp.setRightNode(node);
					break;
				} else {
					if (temp.getLeftNode() != null ) {
						queue.add(temp.getLeftNode());
					}
					if (temp.getRightNode() != null) {
						queue.add(temp.getRightNode());
					}
				}
			}
		}
		return getRoot();
	}
	
	@Override
	public INode removeNode(INode node) {
		// TODO Auto-generated method stub
		return super.removeNode(node);
	}

	@Override
	public Iterator<INode> makeIterator(OrderType orderType) {
		return new IteratorFactory<INode>().makeIterator(orderType, this);
	}

	@Override
	public Iterator<INode> iterator() {
		return new PreOrderIterator<INode>(this);
	}
}
