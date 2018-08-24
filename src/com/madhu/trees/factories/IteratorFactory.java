package com.madhu.trees.factories;

import java.util.HashMap;
import java.util.Iterator;

import com.madhu.trees.ITree;
import com.madhu.trees.iterator.PreOrderIterator;
import com.madhu.trees.model.INode;
import com.madhu.trees.model.OrderType;


public class IteratorFactory<E extends INode> {
	
	HashMap<OrderType, IteratorFactoryCommand<E>> map = new HashMap<>();
	
	// Command Interface
	public static interface IteratorFactoryCommand<E> {
		Iterator<E> execute(ITree tree);
	}
	
	// Factory 
	public IteratorFactory() {
		map.put(OrderType.PREORDER, new IteratorFactoryCommand<E>() {

			@Override
			public Iterator<E> execute(ITree tree) {
				return new PreOrderIterator<E>(tree);

			}
		});
	}
	
	public Iterator<E> makeIterator(OrderType orderType, ITree tree) {
		/*switch (orderType) {
		case PREORDER:
			return new PreOrderIterator<E>(tree);
		default:
			return new PreOrderIterator<E>(tree);
		}*/
		
		return map.get(orderType).execute(tree);
	}
}
