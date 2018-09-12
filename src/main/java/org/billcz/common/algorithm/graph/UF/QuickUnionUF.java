package org.billcz.common.algorithm.graph.UF;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/27
 */
public class QuickUnionUF implements UnionFound {
    int[] parents;
    int count;

    public QuickUnionUF(int count) {
        this.parents = new int[count];
        this.count = count;
        for (int i = 0; i < count; i++) {
            parents[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        parents[rootP] = rootQ;
        count--;
    }

    public int find(int p) {
        while (p != parents[p]) {
            p = parents[p];
        }

        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
