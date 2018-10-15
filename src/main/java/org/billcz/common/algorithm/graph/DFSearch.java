package org.billcz.common.algorithm.graph;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/15
 */
public class DFSearch {
    private boolean[] marked;
    private int count;

    public DFSearch(Graph graph, int s) {
        marked = new boolean[graph.getV()];
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        count++;
        for (int w : graph.adjs(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }


}
