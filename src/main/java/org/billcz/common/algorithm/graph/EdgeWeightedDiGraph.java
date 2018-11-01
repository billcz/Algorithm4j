package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.Bag;
import org.billcz.common.algorithm.util.LinkedListBag;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/11/1
 */
public class EdgeWeightedDiGraph {
    private int V;
    private int E;
    private Bag<Edge>[] adjs;

    public EdgeWeightedDiGraph(int V) {
        this.V = V;
        this.adjs = new LinkedListBag[V];

        for (int i = 0; i < V; i++)
            this.adjs[i] = new LinkedListBag<Edge>();

    }

    public void addEdge(Edge edge) {
        int v = edge.either();

        adjs[v].add(edge);
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
