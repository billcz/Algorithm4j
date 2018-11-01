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
    private Bag<DirectedEdge>[] adjs;

    public EdgeWeightedDiGraph(int V) {
        this.V = V;
        this.adjs = new LinkedListBag[V];

        for (int i = 0; i < V; i++)
            this.adjs[i] = new LinkedListBag<DirectedEdge>();

    }

    public void addEdge(DirectedEdge edge) {
        int v = edge.from();

        adjs[v].add(edge);
        E++;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Iterable<DirectedEdge> adjs(int v) {
        return adjs[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bags = new LinkedListBag<DirectedEdge>();

        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (DirectedEdge e : adjs(v)) {
                int w = e.to();
                bags.add(e);
                if (w == v) {
                    if (selfLoops % 2 == 0) bags.add(e);
                    selfLoops++;
                }
            }
        }

        return bags;
    }

}
