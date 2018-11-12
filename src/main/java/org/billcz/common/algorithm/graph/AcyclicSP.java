package org.billcz.common.algorithm.graph;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/11/1
 */
public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDiGraph graph, int s) {
        this.edgeTo = new DirectedEdge[graph.getV()];
        this.distTo = new double[graph.getV()];

        for (int i = 0; i < graph.getV(); i++)
            this.distTo[i] = Double.POSITIVE_INFINITY;

        Topological topological = new Topological(graph);
        distTo[s] = 0.0;

        for (int v : topological.order()) {
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
        }
    }

}
