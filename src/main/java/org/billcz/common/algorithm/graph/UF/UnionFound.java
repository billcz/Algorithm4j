package org.billcz.common.algorithm.graph.UF;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/24
 */
public interface UnionFound {

    void union(int p, int q);

    int find(int p);

    boolean connected(int p, int q);

    int count();
}
