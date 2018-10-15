package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.LinkedListQueue;
import org.billcz.common.algorithm.util.LinkedListStack;
import org.billcz.common.algorithm.util.Queue;
import org.billcz.common.algorithm.util.Stack;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/15
 */
public class BFPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BFPaths(Graph graph, int s) {
        this.marked = new boolean[graph.getV()];
        this.edgeTo = new int[graph.getV()];
        this.s = s;

        bfs(graph, s);
    }

    private void bfs(Graph graph, int v) {
        Queue<Integer> queue = new LinkedListQueue<Integer>();
        marked[v] = true;
        queue.enqueue(v);

        while (!queue.isEmpty()) {
            int x = queue.dequeue();
            for (int w : graph.adjs(x)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = x;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Integer> paths = new LinkedListStack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            paths.push(x);
        }

        paths.push(s);

        return paths;
    }
}
