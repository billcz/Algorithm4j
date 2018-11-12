package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.LinkedListStack;
import org.billcz.common.algorithm.util.Stack;

/**
 * Description:
 * Author: billcz
 * Create time: 22/10/2018
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(DiGraph diGraph) {
        marked = new boolean[diGraph.getV()];
        edgeTo = new int[diGraph.getV()];
        onStack = new boolean[diGraph.getV()];

        for (int s = 0; s < diGraph.getV(); s++) {
            if (!marked[s])
                dfs(diGraph, s);
        }
    }

    public DirectedCycle(EdgeWeightedDiGraph diGraph) {
        marked = new boolean[diGraph.getV()];
        edgeTo = new int[diGraph.getV()];
        onStack = new boolean[diGraph.getV()];

        for (int s = 0; s < diGraph.getV(); s++) {
            if (!marked[s])
                dfs(diGraph, s);
        }
    }

    private void dfs(DiGraph diGraph, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (int w : diGraph.adjs(v)) {
            if (this.hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(diGraph, w);
            } else if (onStack[w]){
                cycle = new LinkedListStack<Integer>();

                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    private void dfs(EdgeWeightedDiGraph diGraph, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (DirectedEdge e : diGraph.adjs(v)) {
            int w = e.to();
            if (this.hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(diGraph, w);
            } else if (onStack[w]){
                cycle = new LinkedListStack<Integer>();

                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }

        onStack[v] = false;
    }


    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }


}
