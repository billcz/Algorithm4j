package org.billcz.common.algorithm.graph;

/**
 * Description:
 * Author: billcz
 * Create time: 22/10/2018
 */
public class SCC {
    private boolean[] marked;
    private int[] ids;
    private int count;

    public SCC(DiGraph diGraph) {
        this.marked = new boolean[diGraph.getV()];
        this.ids = new int[diGraph.getV()];
        this.count = 0;

        DepthFirstOrder dfOrder = new DepthFirstOrder(diGraph.reverse());

        for (int s : dfOrder.reversePost())
            if (!marked[s]) {
                dfs(diGraph, s);
                count++;
            }
    }

    private void dfs(DiGraph diGraph, int v) {
        marked[v] = true;
        ids[v] = count;

        for (int w : diGraph.adjs(v)) {
            if (!marked[w])
                dfs(diGraph, w);
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return ids[v] == ids[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return ids[v];
    }
}
