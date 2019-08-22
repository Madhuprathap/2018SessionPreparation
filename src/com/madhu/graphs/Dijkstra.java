package com.madhu.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;


/**
 * Greedy algo
 * Single source to destination shortest path algo
 * Modified version of Dijkstra algo (minimal spanning tree)
 *  - Works on directed and un-directed graphs
 *  - Does not work with negative weights
 * O(Elog(v)) - Time
 * O(E+V) - space
 * @author magaddam
 *
 */
public class Dijkstra {
	public static void main(String[] args) {
		int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                {0, 0, 2, 0, 0, 0, 6, 7, 0} 
               }; 
		
		int src = 0;
		int v = graph.length;
		
		int[] parent = Arrays.stream(new int[v]).map(n -> -1).toArray();
		int[] dist = Arrays.stream(new int[v]).map(n -> 0).toArray();
		
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
					dist[i] = graph[src][i];
				} else {
					queue.add(new MinHeapUnit(i, Integer.MAX_VALUE));
					dist[i] = Integer.MAX_VALUE;
				}
			}
		}
		
				
		MinHeapUnit minHeapUnit = null;
		while ((minHeapUnit = (Dijkstra.MinHeapUnit) queue.poll()) != null) {
			for (int i = 0; i < v; i++) {
				// node from minHeapUnit
				Dijkstra.MinHeapUnit nodeToUpdate = getVertexNodeFromQueue(i, queue);
				if (nodeToUpdate != null && graph[minHeapUnit.vertex][i] != 0 && dist[minHeapUnit.vertex] != Integer.MAX_VALUE &&
						nodeToUpdate.distance > dist[minHeapUnit.vertex] + graph[minHeapUnit.vertex][i] ) {
					nodeToUpdate.distance = graph[minHeapUnit.vertex][i] + dist[minHeapUnit.vertex];
					dist[i] = nodeToUpdate.distance;
					parent[i] = minHeapUnit.vertex;
				}
			}
		}
		
		// print distance from source
		for (int i = 0; i < dist.length; i++) {
			System.out.println(i + "  " + dist[i]);
		}
	}
	
	private static MinHeapUnit getVertexNodeFromQueue(int i, PriorityQueue<MinHeapUnit> queue) {
		Iterator<MinHeapUnit> it = queue.iterator();
		while (it.hasNext()) {
			Dijkstra.MinHeapUnit minHeapUnit = (Dijkstra.MinHeapUnit) it.next();
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
