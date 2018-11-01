package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.IndexPriorityQueue;

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

}
