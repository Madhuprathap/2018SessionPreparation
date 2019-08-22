package com.madhu.graphs;

import java.util.Arrays;

/**
 * DP algo
 * All Pairs/single source Shortest Path problem. Can detect -ve cycles too (repeat the loop for more than v-1 times, if distance decrease then we have -ve cycle )
 * 	- Works on directed and un-directed graphs
 *  - Works with negative weights (this over comes limitation of Dijkstra's)
 *  
 *  1) This step initializes distances from source to all vertices as infinite and distance to source itself as 0. Create an array dist[] of size |V| with all values as infinite except dist[src] where src is source vertex.

	2) This step calculates shortest distances. Do following |V|-1 times where |V| is the number of vertices in given graph.
		.a) Do following for each edges u-v
			If dist[v] > dist[u] + weight of edges uv, then update dist[v]
				dist[v] = dist[u] + weight of edges uv

	3) This step reports if there is a negative weight cycle in graph. Do following for each edges u-v
		If dist[v] > dist[u] + weight of edges uv, then “Graph contains negative weight cycle”

 * @author magaddam
 *
 */
public class BellmonFord {
	public static void main(String[] args) {
		int v= 5, e =8;
		Graph graph = new BellmonFord.Graph(v, e);
		// add edges 0-1 (or A-B in above figure) 
        graph.edges[0].src = 0; 
        graph.edges[0].dest = 1; 
        graph.edges[0].weight = -1; 
  
        // add edges 0-2 (or A-C in above figure) 
        graph.edges[1].src = 0; 
        graph.edges[1].dest = 2; 
        graph.edges[1].weight = 4; 
  
        // add edges 1-2 (or B-C in above figure) 
        graph.edges[2].src = 1; 
        graph.edges[2].dest = 2; 
        graph.edges[2].weight = 3; 
  
        // add edges 1-3 (or B-D in above figure) 
        graph.edges[3].src = 1; 
        graph.edges[3].dest = 3; 
        graph.edges[3].weight = 2; 
  
        // add edges 1-4 (or A-E in above figure) 
        graph.edges[4].src = 1; 
        graph.edges[4].dest = 4; 
        graph.edges[4].weight = 2; 
  
        // add edges 3-2 (or D-C in above figure) 
        graph.edges[5].src = 3; 
        graph.edges[5].dest = 2; 
        graph.edges[5].weight = 5; 
  
        // add edges 3-1 (or D-B in above figure) 
        graph.edges[6].src = 3; 
        graph.edges[6].dest = 1; 
        graph.edges[6].weight = 1; 
  
        // add edges 4-3 (or E-D in above figure) 
        graph.edges[7].src = 4; 
        graph.edges[7].dest = 3; 
        graph.edges[7].weight = -3; 
        int src = 0;
        formSingeSrcToOtherDist(graph, src);
	}
	
	private static void formSingeSrcToOtherDist(Graph graph, int src) {
		// to store result
        int dist[] = new int[graph.v];
        // to store parent, will help to construct the path
        int parent[] = new int[graph.v];
        
        //from one source to all other vertex distance
        for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
        dist[src] = 0;
        
        // Step 2: Relax all edges |V| - 1 times. A simple 
        // shortest path from src to any other vertex can 
        // have at-most |V| - 1 edges 
        for (int i = 0; i < graph.v-1; i++) {
        	for (int j = 0; j < graph.edges.length; j++) {
        		int u = graph.edges[j].src; 
                int v = graph.edges[j].dest; 
                int weight = graph.edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE &&
                		dist[v] > dist[u] + weight) {
                	dist[v] = dist[u] + weight;
                	parent[v] = u;
				}
    		}
		}
        
        // Check for -ve cycle
        for (int j = 0; j < graph.edges.length; j++) {
    		int u = graph.edges[j].src; 
            int v = graph.edges[j].dest; 
            int weight = graph.edges[j].weight;
            if (dist[u] != Integer.MAX_VALUE &&
            		dist[v] > dist[u] + weight) {
            	System.out.println("there is a -ve cycle");
			}
		}
        
        Arrays.stream(dist).forEach(System.out::println);
		
	}

	static class Graph {
		class edges {
			int src,dest,weight;
		}
		int v,e;
		edges[] edges;
		public Graph(int v, int e) {
			super();
			this.v = v;
			this.e = e;
			edges = new edges[e];
			 for (int i=0; i<e; ++i) 
				 edges[i] = new edges(); 
		}
	}
}
