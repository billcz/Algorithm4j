package org.billcz.common.graph;

import org.billcz.common.algorithm.graph.BFPaths;
import org.billcz.common.algorithm.graph.DFPaths;
import org.billcz.common.algorithm.graph.DFSearch;
import org.billcz.common.algorithm.graph.Graph;


/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/15
 */
public class GraphTest {

    public static boolean isContect(Graph graph, int s, int w) {
        DFSearch dfSearch = new DFSearch(graph, s);
        return dfSearch.marked(w);
    }

    public static boolean hasPathWithDFS(Graph graph, int s, int v) {
        DFPaths dfPaths = new DFPaths(graph, s);
        Iterable<Integer> paths = dfPaths.pathTo(v);
        if (paths != null) {
            for (Integer w : paths) {
                System.out.print(w + " ");
            }
        }

        return dfPaths.hasPathTo(v);
    }

    public static boolean hasPathWithBFS(Graph graph, int s, int v) {
        BFPaths bfPaths = new BFPaths(graph, s);
        Iterable<Integer> paths = bfPaths.pathTo(v);
        if (paths != null) {
            for (Integer w : paths) {
                System.out.print(w + " ");
            }
        }

        return bfPaths.hasPathTo(v);
    }


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

        System.out.println(isContect(graph, 9, 1));
        System.out.println(hasPathWithDFS(graph, 2, 4));
        System.out.println(hasPathWithBFS(graph, 2, 4));
    }
}
