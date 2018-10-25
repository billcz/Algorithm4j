package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.LinkedListQueue;
import org.billcz.common.algorithm.util.PriorityQueue;
import org.billcz.common.algorithm.util.Queue;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/24
 */
public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph graph) {
        this.marked = new boolean[graph.getV()];
        this.mst = new LinkedListQueue<Edge>();
        this.pq = new PriorityQueue<Edge>(graph.getE(), new Comparator<Edge>() {
            public int compare(Edge o1, Edge o2) {
                return o1.compareTo(o2);
            }
        });

        visit(graph, 0);

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e) ;
            if (!marked[v]) visit(graph, v);
            if (!marked[w]) visit(graph, w);
        }
    }

    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge e : graph.adjs(v))
              if (!marked[e.other(v)])
                 pq.add(e);
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge e : mst)
            weight += e.weight();

        return weight;
    }
}
