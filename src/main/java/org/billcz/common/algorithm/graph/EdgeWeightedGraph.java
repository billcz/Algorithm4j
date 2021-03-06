package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.Bag;
import org.billcz.common.algorithm.util.LinkedListBag;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/24
 */
public class EdgeWeightedGraph {
    private int V;
    private int E;
    private Bag<Edge>[] adjs;

    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        this.adjs = new LinkedListBag[v];

        for (int i = 0; i < v; i++)
            this.adjs[i] = new LinkedListBag<Edge>();

    }

    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);

        adjs[v].add(edge);
        adjs[w].add(edge);

        E++;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Iterable<Edge> adjs(int v) {
        return adjs[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> bags = new LinkedListBag<Edge>();

        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adjs(v)) {
                int w = e.other(v);
                if (w > v) bags.add(e);
                else if (w == v) {
                    if (selfLoops % 2 == 0) bags.add(e);
                    selfLoops++;
                }
            }
        }
        return bags;
    }
}
