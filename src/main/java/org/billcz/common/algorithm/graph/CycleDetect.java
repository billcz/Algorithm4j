package org.billcz.common.algorithm.graph;

/**
 * Description:
 * Author: billcz
 * Create time: 15/10/2018
 */
public class CycleDetect {
    private boolean[] marked;
    private boolean hasCycle = false;

    public CycleDetect(Graph graph) {
        this.marked = new boolean[graph.getV()];

        for (int s = 0; s < graph.getV(); s++) {
            if (!marked[s]) {
                dfs(graph, s, s);
            }
        }
    }

    private void dfs(Graph graph, int v, int p) {
        marked[v] = true;
        for (int w : graph.adjs(v)) {
            if (!marked[w])
                dfs(graph, w, v);
            else if (w != p) hasCycle = true;
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

}
