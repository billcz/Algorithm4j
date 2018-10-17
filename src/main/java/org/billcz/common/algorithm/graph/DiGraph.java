package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.Bag;
import org.billcz.common.algorithm.util.LinkedListBag;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/17
 */
public class DiGraph {
    private int V;
    private int E;
    private Bag<Integer>[] adjs;

    public DiGraph(int V) {
        this.V = V;
        this.adjs = new LinkedListBag[V];

        for (int i = 0; i < V; i++) {
            adjs[i] = new LinkedListBag<Integer>();
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(int u, int v) {
        if (!isValidVertex(u) || !isValidVertex(v)) return;

        this.adjs[u].add(v);
        this.E++;
    }

    public Iterable<Integer> adjs(int v) {
        if (!isValidVertex(v)) return null;

        return adjs[v];
    }

    private boolean isValidVertex(int v) {
        return v >=0 && v < V;
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
}
