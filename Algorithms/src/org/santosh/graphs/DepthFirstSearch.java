package org.santosh.graphs;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	
	public DepthFirstSearch(Graph g,int s){
		marked=new boolean[g.getV()];
		dfs(g,s);
	}

	private void dfs(Graph g, int s) {
		// TODO Auto-generated method stub
		marked[s]=true;
		count++;
		for(int w:g.adj(s)){
			if(!marked[w]) dfs(g,w);
		}
	}
	
	public int count() {
		return count;
	}
	
	
}
