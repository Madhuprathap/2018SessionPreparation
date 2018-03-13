package com.madhu.trees.factories;

import com.madhu.trees.ITree;

public interface TreeAbstractFactory {
	ITree CreateTree(String expression, ExpressoinOrder order);
}
