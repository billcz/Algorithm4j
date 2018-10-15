package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.LinkedListStack;
import org.billcz.common.algorithm.util.Stack;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/15
 */
public class DFPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DFPaths(Graph graph, int s) {
        this.marked = new boolean[graph.getV()];
        this.edgeTo = new int[graph.getV()];
        this.s = s;

        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;

        for (int w : graph.adjs(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> paths = new LinkedListStack<Integer>();
        for (int w = v; w != s; w = edgeTo[w]) {
            paths.push(w);
        }
        paths.push(s);
        return paths;
    }
}
