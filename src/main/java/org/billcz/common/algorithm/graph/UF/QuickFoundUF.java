package org.billcz.common.algorithm.graph.UF;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/24
 */
public class QuickFoundUF implements UnionFound {
    int[] ids;
    int count;

    public QuickFoundUF(int size) {
        ids = new int[size];

        for (int i = 0; i < size; i++) {
            ids[i] = i;
            count++;
        }

    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pId) ids[i] = qId;
        }

        count--;
    }

    public int find(int p) {
        return ids[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
