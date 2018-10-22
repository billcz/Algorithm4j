package org.billcz.common.algorithm.graph;

/**
 * Description:
 * Author: billcz
 * Create time: 22/10/2018
 */
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(DiGraph diGraph, int s) {
        marked = new boolean[diGraph.getV()];

        dfs(diGraph, s);
    }

    private void dfs(DiGraph diGraph, int v) {
        marked[v] = true;

        for (int w : diGraph.adjs(v)) {
            if (!marked[w])
                dfs(diGraph, w);
        }

    }

    public boolean marked(int v) {
        return marked[v];
    }


}
