package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.IndexPriorityQueue;
import org.billcz.common.algorithm.util.LinkedListQueue;
import org.billcz.common.algorithm.util.Queue;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/24
 */
public class PrimMST {
    private boolean[] marked;
    private Edge[] edgeTo;
    private double[] distTo;
    private IndexPriorityQueue<Double> minPQ;

    public PrimMST(EdgeWeightedGraph graph) {
        this.marked = new boolean[graph.getV()];
        this.edgeTo = new Edge[graph.getV()];
        this.distTo = new double[graph.getV()];

        for (int i = 0; i < graph.getV(); i++)
            this.distTo[i] = Double.POSITIVE_INFINITY;

        minPQ = new IndexPriorityQueue<Double>(graph.getV());

        relax(graph, 0);

        while (!minPQ.isEmpty()) {
            int v = minPQ.pollIndex();
            if (!marked[v])
                relax(graph, v);
        }
    }

    private void relax(EdgeWeightedGraph graph, int s) {
        marked[s] = true;

        for (Edge e : graph.adjs(s)) {
            int w = e.other(s);
            if (marked[w]) continue;
            if (distTo[w] > e.weight()) {
                edgeTo[w] = e;
                distTo[w] = e.weight();

                if (minPQ.contains(w)) minPQ.update(w, distTo[w]);
                else minPQ.add(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> queue = new LinkedListQueue<Edge>();
        for (Edge anEdgeTo : edgeTo)
            if (anEdgeTo != null)
                queue.enqueue(anEdgeTo);

        return queue;
    }

    public double weight() {
        double weight = 0;

        for (Edge edge : edges())
            weight += edge.weight();

        return weight;
    }



}
