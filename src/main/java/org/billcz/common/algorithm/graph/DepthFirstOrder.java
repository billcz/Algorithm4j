package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.LinkedListQueue;
import org.billcz.common.algorithm.util.LinkedListStack;
import org.billcz.common.algorithm.util.Queue;
import org.billcz.common.algorithm.util.Stack;

/**
 * Description:
 * Author: billcz
 * Create time: 22/10/2018
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(DiGraph diGraph) {
        this.marked = new boolean[diGraph.getV()];
        pre = new LinkedListQueue<Integer>();
        post = new LinkedListQueue<Integer>();
        reversePost = new LinkedListStack<Integer>();

        for (int s = 0; s < diGraph.getV(); s++) {
            if (!marked[s])
                dfs(diGraph, s);
        }
    }

    public DepthFirstOrder(EdgeWeightedDiGraph diGraph) {
        this.marked = new boolean[diGraph.getV()];
        pre = new LinkedListQueue<Integer>();
        post = new LinkedListQueue<Integer>();
        reversePost = new LinkedListStack<Integer>();

        for (int s = 0; s < diGraph.getV(); s++) {
            if (!marked[s])
                dfs(diGraph, s);
        }
    }

    private void dfs(DiGraph diGraph, int v) {
        marked[v] = true;
        pre.enqueue(v);

        for (int w : diGraph.adjs(v)) {
            if (!marked[w])
                dfs(diGraph, w);
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    private void dfs(EdgeWeightedDiGraph diGraph, int v) {
        marked[v] = true;
        pre.enqueue(v);

        for (DirectedEdge e : diGraph.adjs(v)) {
            int w = e.to();
            if (!marked[w])
                dfs(diGraph, w);
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

}
