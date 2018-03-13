package com.madhu.linkedlist;

public interface ILinkedList<N> {
	N addNode(N node);
	N removeNodeAtEnd();
	N removeNodeAtIndex(Integer index);
}
