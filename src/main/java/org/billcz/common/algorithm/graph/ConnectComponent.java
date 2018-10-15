package org.billcz.common.algorithm.graph;

/**
 * Description:
 * Author: billcz
 * Create time: 15/10/2018
 */
public class ConnectComponent {
    private boolean[] marked;
    private int[] ids;
    private int count;

    public ConnectComponent(Graph graph) {
        this.marked = new boolean[graph.getV()];
        this.ids = new int[graph.getV()];

        count = 0;

        for (int s = 0; s < graph.getV(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }

    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        ids[v] = count;
        for (int w : graph.adjs(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return ids[v] == ids[w];
    }

    public int id(int v) {
        return ids[v];
    }

    public int count() {
        return count;
    }
}
