package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.IndexPriorityQueue;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/11/1
 */
public class DijkstraSP {
    private Edge[] edgeTo;
    private double[] distTo;
    private IndexPriorityQueue<Edge> minPQ;

    public DijkstraSP(EdgeWeightedDiGraph graph) {
        this.edgeTo = new Edge[graph.getV()];
        this.distTo = new double[graph.getV()];
        this.minPQ = new IndexPriorityQueue<Edge>(graph.getV());
    }

}
