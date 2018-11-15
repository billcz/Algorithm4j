package org.billcz.common.algorithm.graph;

import org.billcz.common.algorithm.util.LinkedListQueue;
import org.billcz.common.algorithm.util.Queue;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/11/15
 */
public class BellmanFordSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private Queue<Integer> queue;
    private boolean[] onQueue;
    private Iterable<DirectedEdge> cycle;
    private int cost;

    public BellmanFordSP(EdgeWeightedDiGraph diGraph, int s) {
        this.distTo = new double[diGraph.getV()];
        this.edgeTo = new DirectedEdge[diGraph.getV()];
        this.queue = new LinkedListQueue<Integer>();
        this.onQueue = new boolean[diGraph.getV()];

        for (int i = 0; i < diGraph.getV(); i++)
            this.distTo[i] = Double.POSITIVE_INFINITY;

        distTo[s] = 0.0;
        queue.enqueue(s);
        onQueue[s] = true;

        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.dequeue();
            onQueue[v] = false;
            relax(diGraph, v);
        }
    }

    private void relax(EdgeWeightedDiGraph diGraph, int v) {
        for (DirectedEdge e : diGraph.adjs(v)) {
            int w = e.to();
            if (distTo[w] > e.weight() + distTo[v]) {
                distTo[w] = e.weight() + distTo[v];
                edgeTo[w] = e;
                if (!onQueue[w]) {
                    queue.enqueue(w);
                    onQueue[w] = true;
                }
            }

            if (cost++ %diGraph.getV() == 0) {
                findNegativeCycle();
                if (hasNegativeCycle()) return;
            }
        }
    }

    private boolean hasNegativeCycle() {
        return cycle != null;
    }

    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDiGraph e = new EdgeWeightedDiGraph(V);
        for (DirectedEdge anEdgeTo : edgeTo)
            if (anEdgeTo != null)
                e.addEdge(anEdgeTo);

        EdgeWeightedDirectedCycle cycleDetect = new EdgeWeightedDirectedCycle(e);
        cycle = cycleDetect.cycle();
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] <= Double.POSITIVE_INFINITY;
    }
}
