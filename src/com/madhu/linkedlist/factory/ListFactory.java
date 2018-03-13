package com.madhu.linkedlist.factory;

import java.util.HashMap;

import com.madhu.linkedlist.ILinkedList;

public class ListFactory<E extends ILinkedList<I>, I> {
	
	private HashMap<String, IListFactory<E>> map =  new HashMap<>();
	
	public ListFactory() {
		map.put("SINGLE", new SingleLinkedListFactory<E, I>());
	}
	
	public IListFactory<E> getFactory(String type) {
		if (type.equals("")) {
			type = "SINGLE";
		}
		return map.get(type.toUpperCase());
	}
}
