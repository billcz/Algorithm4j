package org.billcz.common.algorithm.graph;

/**
 * Description:
 * Author: billcz
 * Create time: 15/10/2018
 */
public class TwoColorDetect {
    private boolean[] marked;
    private boolean[] colors;
    private boolean twoColor = true;

    public TwoColorDetect(Graph graph) {
        this.marked = new boolean[graph.getV()];

        for (int s = 0; s < graph.getV(); s++) {
            if (!marked[s])
                dfs(graph, s);
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;

        for (int w : graph.adjs(v)) {
            if (!marked[w]) {
                colors[w] = !colors[v];
                dfs(graph, w);
            } else if (colors[w] == colors[v]) {
                twoColor = false;
            }
        }
    }

    public boolean hasTwoColor() {
        return twoColor;
    }


}
