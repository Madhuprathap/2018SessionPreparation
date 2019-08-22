package com.madhu.graphs;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * DP algo
 * All Pairs Shortest Path problem. Can detect -ve cycles to (if any value in the diagonal position of the solution is -ve means there is a -ve cycle)
 * 	- Works on directed and un-directed graphs
 *  - Works with negative weights
 * we pick vertex number k as an intermediate vertex, we already have considered vertices {0, 1, 2, .. k-1} as intermediate vertices. For every pair (i, j) of the source and destination vertices respectively, there are two possible cases.
 * 1) k is not an intermediate vertex in shortest path from i to j. We keep the value of dist[i][j] as it is.
 * 2) k is an intermediate vertex in shortest path from i to j. We update the value of dist[i][j] as dist[i][k] + dist[k][j] if dist[i][j] > dist[i][k] + dist[k][j]
 * @author magaddam
 *
 */
public class FloydWarshall {

	// Can not user max_value, if we add a number to max_value it goes to negative value.
//	private static int INF = Integer.MAX_VALUE;
	private static int INF = 9999;
	
	public static void main(String[] args) {
		/* Let us create the following weighted graph 
        10 
     (0)------->(3) 
      |         /|\ 
   5  |          | 
      |          | 1 
     \|/         | 
     (1)------->(2) 
        3           */
		// Distance matrix
		int graph[][] = { {0,   5,  INF, 10}, 
				{INF, 0,   3, INF}, 
				{INF, INF, 0,   1}, 
				{INF, INF, INF, 0} 
		};

		// Direct edges. When to direct edge mean we can have via K a possible path.
		int path[][] = {
				{-1, 0, -1, 0},
				{-1, -1, 1, -1},
				{-1, -1, -1, 2},
				{-1, -1,-1, -1}
		};
		
		// Time complexity : O(V^3)
		// Space complexity : 0(V^2)
		for (int k = 0; k < graph.length; k++) {
			for (int i = 0; i < path.length; i++) {
				for (int j = 0; j < path.length; j++) {
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
						// path is via K vertex from i to j
						path[i][j] = path[k][j];
					}
				}
			}
		}
		
		// if any value in the diagonal position of the solution is -ve means there is a -ve cycle
		Stream.of(graph).map(Arrays::toString).forEach(System.out::println);
		
		Arrays.stream(path).map(Arrays::toString).forEach(System.out::println);
		/*		[-1, 0, 1, 2]
				[-1, -1, 1, 2]
				[-1, -1, -1, 2]
				[-1, -1, -1, -1] */
		// shortest path from  1 to 3. 
		// [1][3] = 2 so path will 1-> ** ->2->3 
		// repeat it still we reach source.
		// [1][2] = 1 so path will be 1->2-> 3
	}

}
