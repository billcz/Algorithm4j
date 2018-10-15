package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.Bag;
import org.billcz.common.algorithm.util.LinkedListBag;
import org.billcz.common.algorithm.util.LinkedListStack;
import org.billcz.common.algorithm.util.Stack;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/15
 */
public class Graph {
    private int V;
    public int E;
    private Bag<Integer>[] adjs;

    public Graph(int V) {
        this.V = V;
        adjs = new LinkedListBag[this.V];
        for (int v = 0; v < V; v++) {
            adjs[v] = new LinkedListBag<Integer>();
        }
    }

    public Graph(Graph g) {
        this(g.getV());
        this.E = g.getE();

        for (int v = 0; v < getV(); v++) {
            Stack<Integer> reverse = new LinkedListStack<Integer>();

            for (int w : g.adjs(v)) {
                reverse.push(w);
            }

            for (int w : reverse) {
                this.adjs[v].add(w);
            }
        }

    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(int v, int w) {
        if (!isValidVertex(v) || !isValidVertex(w)) return;

        adjs[v].add(w);
        adjs[w].add(v);
        this.E++;
    }

    public Iterable<Integer> adjs(int v) {
        return adjs[v];
    }

    public int degree(int v) {
        return adjs[v].size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + "," + E + "\n");

        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adjs(v)) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private boolean isValidVertex(int v) {
        return v >= 0 && v < V;
    }

}
