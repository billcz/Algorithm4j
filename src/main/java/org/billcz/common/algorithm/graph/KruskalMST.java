package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.graph.UF.QuickUnionUF;
import org.billcz.common.algorithm.util.LinkedListQueue;
import org.billcz.common.algorithm.util.PriorityQueue;
import org.billcz.common.algorithm.util.Queue;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/31
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph graph) {
        mst = new LinkedListQueue<Edge>();
        PriorityQueue<Edge> minPQ = new PriorityQueue<Edge>(graph.getE(), new Comparator<Edge>() {
            public int compare(Edge o1, Edge o2) {
                return o1.compareTo(o2);
            }
        });

        QuickUnionUF uf = new QuickUnionUF(graph.getV());
        for (Edge e : graph.edges())
            minPQ.add(e);

        while (!minPQ.isEmpty() && mst.size() < (graph.getV() - 1)) {
            Edge e = minPQ.poll();
            int v = e.either();
            int w = e.other(v);

            if (uf.connected(v, w)) continue;

            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0;
        for (Edge e : mst)
            weight += e.weight();

        return weight;
    }



}
