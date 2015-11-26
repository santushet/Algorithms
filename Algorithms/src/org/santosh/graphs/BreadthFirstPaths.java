package org.santosh.graphs;

import java.util.LinkedList;
import java.util.Stack;

import edu.princeton.cs.algs4.Queue;

//Breadth-first search to find paths in a graph

public class BreadthFirstPaths {
	private boolean[] marked; // Has dfs() been called for this vertex?
	private int[] edgeTo; // last vertex on known path to this vertex
	private int s; // source

	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph g, int s) {
		// TODO Auto-generated method stub
		Queue<Integer> qu = new Queue<Integer>();
		qu.enqueue(s);
		marked[s] = true;
		while (!qu.isEmpty()) {
			int v = qu.dequeue();
			for (int w : g.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					qu.enqueue(w);
					edgeTo[w] = v;
				}
			}
		}

	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<>();
		// LinkedList<Integer> path=new LinkedList<Integer>();
		for (int i = v; i != s; i = edgeTo[i])
			path.push(i);
		path.push(s);
		return path;
	}
	
	public static void main(String[] args) {
		Graph G = new Graph(6);
		G.addEdge(0, 2);
		G.addEdge(0, 1);
		G.addEdge(0, 5);
		G.addEdge(3, 5);
		G.addEdge(3, 2);
		G.addEdge(3, 4);
		G.addEdge(2, 4);
		G.addEdge(1, 2);
		
		System.out.println(G.toString());
		int s = 0;
		//DepthFirstPaths paths = new DepthFirstPaths(G, s);
		BreadthFirstPaths paths=new BreadthFirstPaths(G, s);
		Stack<Integer> pathStack=new Stack<>();
		System.out.println("Paths from source "+s);
		for (int v = 0; v < G.getV(); v++) {
			System.out.print(s + " to " + v + ": ");
			if (paths.hasPathTo(v))
				for (int w : paths.pathTo(v)) 
					pathStack.push(w);
				while(!pathStack.isEmpty()){
					int value=pathStack.pop();
					if (value == s)
						System.out.print(value);
					else
						System.out.print("-" +value);}
				
			System.out.println();
		}
	}

}
