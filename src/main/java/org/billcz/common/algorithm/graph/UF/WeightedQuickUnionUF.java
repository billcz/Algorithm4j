package org.billcz.common.algorithm.graph.UF;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/27
 */
public class WeightedQuickUnionUF implements UnionFound {
    int[] parents;
    int[] sizes;
    int count;

    public WeightedQuickUnionUF(int n) {
        this.parents = new int[n];
        this.sizes = new int[n];
        this.count = n;

        for (int i = 0; i < n; i++) {
            this.parents[i] = i;
            this.sizes[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (sizes[p] < sizes[q]) {
            parents[rootP] = rootQ;
            sizes[rootQ] += sizes[rootP];
        } else {
            parents[rootQ] = rootP;
            sizes[rootP] += sizes[rootQ];
        }

        count--;

    }

    public int find(int p) {
        while (p != parents[p])
            p = parents[p];

        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
