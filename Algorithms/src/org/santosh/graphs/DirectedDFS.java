package org.santosh.graphs;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

//Reachability in digraphs

public class DirectedDFS {
	private boolean[] marked; // Has dfs() been called for this vertex?

	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.getV()];
		// edgeTo = new int[G.getV()];
		// this.s = s;
		dfs(G, s);
	}

	public DirectedDFS(Digraph g, ArrayList<Integer> sources) {
		// TODO Auto-generated constructor stub
		marked = new boolean[g.getV()];
		for (int s : sources)
			if (!marked[s])
				dfs(g, s);
	}

	private void dfs(Digraph g, int v) {
		// TODO Auto-generated method stub
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				// edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public static void main(String[] args) {

		Digraph G = new Digraph(6);
		G.addEdge(0, 2);
		G.addEdge(0, 1);
		G.addEdge(0, 5);
		G.addEdge(3, 5);
		G.addEdge(3, 2);
		G.addEdge(3, 4);
		G.addEdge(2, 4);
		G.addEdge(1, 2);

		// System.out.println(G.toString());
		ArrayList<Integer> sources = new ArrayList<Integer>();
		sources.add(1);
		sources.add(2);
		sources.add(3);
		System.out.println(G.toString());
		DirectedDFS reachable = new DirectedDFS(G, sources);
		System.out.print("Reachable elements are ");
		for (int v = 0; v < G.getV(); v++)
			if (reachable.marked(v))
				System.out.print(v + " ");
		System.out.println();

	}

}
