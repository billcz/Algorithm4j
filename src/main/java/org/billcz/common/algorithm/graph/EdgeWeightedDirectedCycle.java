package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.LinkedListStack;
import org.billcz.common.algorithm.util.Stack;

/**
 * Description:
 * Author: billcz
 * Create time: 22/10/2018
 */
public class EdgeWeightedDirectedCycle {
    private boolean[] marked;
    private DirectedEdge[] edgeTo;
    private Stack<DirectedEdge> cycle;
    private boolean[] onStack;

    public EdgeWeightedDirectedCycle(EdgeWeightedDiGraph diGraph) {
        marked = new boolean[diGraph.getV()];
        edgeTo = new DirectedEdge[diGraph.getV()];
        onStack = new boolean[diGraph.getV()];

        for (int s = 0; s < diGraph.getV(); s++) {
            if (!marked[s])
                dfs(diGraph, s);
        }
    }

    private void dfs(EdgeWeightedDiGraph diGraph, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (DirectedEdge e : diGraph.adjs(v)) {
            int w = e.to();
            if (this.hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = e;
                dfs(diGraph, w);
            } else if (onStack[w]){
                cycle = new LinkedListStack<DirectedEdge>();

                for (DirectedEdge x = e; x.from() != w; x = edgeTo[x.from()])
                    cycle.push(x);

                cycle.push(e);
            }
        }

        onStack[v] = false;
    }


    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> cycle() {
        return cycle;
    }


}
