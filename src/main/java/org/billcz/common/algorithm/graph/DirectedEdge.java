package org.billcz.common.algorithm.graph;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/24
 */
public class DirectedEdge implements Comparable<DirectedEdge> {
    private int v;
    private int w;
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public int compareTo(DirectedEdge o) {
        return Double.compare(this.weight, o.weight);
    }

    @Override
    public String toString() {
        return  v+ "->" + w + ":" + weight;
    }
}
