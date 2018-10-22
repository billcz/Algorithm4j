package org.billcz.common.algorithm.graph;

/**
 * Description:
 * Author: billcz
 * Create time: 22/10/2018
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(DiGraph diGraph) {
        DirectedCycle directedCycle = new DirectedCycle(diGraph);

        if (!directedCycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(diGraph);
            order = depthFirstOrder.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}
