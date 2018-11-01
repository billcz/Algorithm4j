package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.IndexPriorityQueue;
import org.billcz.common.algorithm.util.LinkedListStack;
import org.billcz.common.algorithm.util.Stack;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/11/1
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexPriorityQueue<Double> minPQ;

    public DijkstraSP(EdgeWeightedDiGraph graph, int s) {
        this.edgeTo = new DirectedEdge[graph.getV()];
        this.distTo = new double[graph.getV()];
        this.minPQ = new IndexPriorityQueue<Double>(graph.getV());

        for (int i = 0; i < graph.getV(); i++)
            this.distTo[i] = Double.POSITIVE_INFINITY;

        distTo[s] = 0.0;
        minPQ.add(s, distTo[s]);

        while (!minPQ.isEmpty()) {
            int v = minPQ.pollIndex();
            for (DirectedEdge e : graph.adjs(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        if (distTo[w] > e.weight() + distTo[v]) {
            edgeTo[w] = e;
            distTo[w] = e.weight() + distTo[v];
            if (minPQ.contains(w)) minPQ.update(w, distTo[w]);
            else minPQ.add(w, distTo[w]);
        }
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<DirectedEdge> path = new LinkedListStack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }

        return path;
    }

}
