package org.santosh.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Depth-first search to find paths in a graph
public class DepthFirstPaths {

	private boolean[] marked; // Has dfs() been called for this vertex?
	private int[] edgeTo; // last vertex on known path to this vertex
	private int s; // source

	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		this.s = s;
		dfs(G, s);
	}

	private void dfs(Graph g, int v) {
		// TODO Auto-generated method stub
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}

	
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		List path = new ArrayList<>();
		for (int i = v; i != s; i = edgeTo[i])
			path.add(i);
		path.add(s);
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
		DepthFirstPaths paths = new DepthFirstPaths(G, s);
		//BreadthFirstPaths paths = new BreadthFirstPaths(G, s);
		Stack<Integer> pathStack = new Stack<>();
		System.out.println("Paths from source " + s);
		for (int v = 0; v < G.getV(); v++) {
			System.out.print(s + " to " + v + ": ");
			if (paths.hasPathTo(v))
				for (int w : paths.pathTo(v))
					pathStack.push(w);
			while (!pathStack.isEmpty()) {
				int value = pathStack.pop();
				if (value == s)
					System.out.print(value);
				else
					System.out.print("-" + value);
			}

			System.out.println();
		}
	}
}
