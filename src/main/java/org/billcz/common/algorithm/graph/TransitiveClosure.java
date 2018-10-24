package org.billcz.common.algorithm.graph;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/24
 */
public class TransitiveClosure {
    private DirectedDFS[] dfs;

    public TransitiveClosure(DiGraph diGraph) {
        this.dfs = new DirectedDFS[diGraph.getV()];

        for (int s = 0; s < diGraph.getV(); s++)
            dfs[s] = new DirectedDFS(diGraph, s);
    }

    public boolean connect(int v, int w) {
        return dfs[v].marked(w);
    }

}
