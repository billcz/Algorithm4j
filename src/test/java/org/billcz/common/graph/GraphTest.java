package org.billcz.common.graph;

import org.billcz.common.algorithm.graph.Graph;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/15
 */
public class GraphTest {


    public static void main(String[] args) {
        String tinyG = "0 5\n" +
                "4 3\n" +
                "0 1\n" +
                "9 12\n" +
                "6 4\n" +
                "5 4\n" +
                "0 2\n" +
                "11 12\n" +
                "9 10\n" +
                "0 6\n" +
                "7 8\n" +
                "9 11\n" +
                "5 3";

        Graph graph = new Graph(13);
        String[] fields = tinyG.split("\n");
        for (String field : fields) {
            String[] vals = field.split(" ");
            int v = Integer.parseInt(vals[0]);
            int w= Integer.parseInt(vals[1]);
            graph.addEdge(v, w);
        }

        System.out.println(graph.toString());

        Graph copy = new Graph(graph);
        System.out.println(copy.toString());
    }
}
