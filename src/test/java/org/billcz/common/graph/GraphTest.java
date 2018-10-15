package org.billcz.common.graph;

import org.billcz.common.algorithm.graph.Graph;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/15
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        for (int v = 0; v < 5; v++) {
            for (int w = 1; w < 5; w++) {
                graph.addEdge(v, w);
            }
        }
        System.out.println(graph.toString());

        Graph copy = new Graph(graph);
        System.out.println(copy.toString());
    }
}
