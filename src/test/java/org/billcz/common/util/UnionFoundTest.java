package org.billcz.common.util;

import org.billcz.common.algorithm.graph.UF.UnionFound;
import org.billcz.common.algorithm.graph.UF.WeightedQuickUnionUF;

import java.util.Random;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/27
 */
public class UnionFoundTest {
    public static void main(String[] args) {
        int size = 100;
        Random random = new Random(System.currentTimeMillis());
        UnionFound uf = new WeightedQuickUnionUF(size);
        int[] val1 = new int[size];
        int[] val2 = new int[size];
        for (int i = 0; i < size; i++) {
            val1[i] = random.nextInt(size);
            val2[i] = random.nextInt(size);
            if (uf.connected(val1[i], val2[i])) continue;

            uf.union(val1[i], val2[i]);
            System.out.println(val1[i] + " " + val2[i]);
        }

        int p = random.nextInt(size);
        int q = random.nextInt(size);
        System.out.println(p + " " + q + " " + uf.connected(p, q));
        System.out.println(uf.count());

    }
}
