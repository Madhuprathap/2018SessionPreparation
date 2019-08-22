package com.madhu.graphs.MST;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Greedy algo
 * - works with negative weights & directed and un-directed edges
 * - O(Elog(v))
 * Algo start with selecting a vertex as source
 * @author magaddam
 *
 */
public class Prims {
	public static void main(String[] args) {
		int v = 5;
		int graph[][] = {{0, 2, 0, 6, 0}, 
                {2, 0, 3, 8, 5}, 
                {0, 3, 0, 0, 7}, 
                {6, 8, 0, 0, 9}, 
                {0, 5, 7, 9, 0}}; 
		
		int src = 0;
		
		// Map parent = new HashMap();
		int[] parent = Arrays.stream(new int[v]).map(n -> -1).toArray();
		
		// to perform min heap
		PriorityQueue<MinHeapUnit> queue = new PriorityQueue<MinHeapUnit>(new Comparator<MinHeapUnit>() {
			@Override
			public int compare(MinHeapUnit o1, MinHeapUnit o2) {
				return o1.distance.compareTo(o2.distance);
			};
		});
		
		// base case
		// Populate source to other destination distance
		for (int i = 0; i < v; i++) {
			if (i != src) {
				if (graph[src][i] != 0) {
					queue.add(new MinHeapUnit(i, graph[src][i]));
					parent[i] = src;
				} else {
					queue.add(new MinHeapUnit(i, Integer.MAX_VALUE));
				}
			}
		}
		
				
		MinHeapUnit minHeapUnit = null;
		while ((minHeapUnit = (Prims.MinHeapUnit) queue.poll()) != null) {
			for (int i = 0; i < v; i++) {
				Prims.MinHeapUnit nodeToUpdate = getVertexNodeFromQueue(i, queue);
				if (nodeToUpdate != null && graph[minHeapUnit.vertex][i] != 0 && nodeToUpdate.distance > graph[minHeapUnit.vertex][i]) {
					nodeToUpdate.distance = graph[minHeapUnit.vertex][i];
					parent[i] = minHeapUnit.vertex;
				}
			}
		}
		
		// print mst
		for (int i = 1; i < parent.length; i++) {
			System.out.println(parent[i] + "->" + i + "  " + graph[parent[i]][i]);
		}
	}
	
	private static MinHeapUnit getVertexNodeFromQueue(int i, PriorityQueue<MinHeapUnit> queue) {
		Iterator<MinHeapUnit> it = queue.iterator();
		while (it.hasNext()) {
			Prims.MinHeapUnit minHeapUnit = (Prims.MinHeapUnit) it.next();
			if (i == minHeapUnit.vertex) {
				return minHeapUnit;
			}
		}
		return null;
	}

	static class MinHeapUnit {
		public MinHeapUnit(int v, int d) {
			vertex = v;
			distance = d;
		}
		Integer vertex;
		Integer distance;
	}
}
