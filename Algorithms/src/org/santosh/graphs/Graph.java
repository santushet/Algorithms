package org.santosh.graphs;

import java.util.ArrayList;

//Undirected Graph data type

public class Graph {

	private int V;
	private int E;
	private ArrayList<Integer>[] adj;

	// Constructor to initialize graph variables
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}

	public int getV() {
		return V;
	}

	public int getE() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		this.E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public String toString() {
		String s=V+ " vertices, "+E+" edges\n";
		s+="Adjacency List: \n";
		for(int v=0;v<V;v++){
			s+=v+":";
			for(int w:this.adj(v)){
				s+=w+" ";
			}
			s+="\n";
		}
		return s;
	}

}
