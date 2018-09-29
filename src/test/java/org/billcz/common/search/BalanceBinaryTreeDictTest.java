package org.billcz.common.search;

import org.billcz.common.algorithm.search.BalanceBinaryTreeDict;
import org.billcz.common.algorithm.search.SortDict;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/26
 */
public class BalanceBinaryTreeDictTest {
    public static void main(String[] args) {
        SortDict<Integer, String> sortDict = new BalanceBinaryTreeDict<Integer, String>();

        for (int i = 0; i < 100; i++) {
            sortDict.put(i, "i" + i);
        }
        System.out.println(sortDict.size());
        sortDict.remove(99);
        System.out.println(sortDict.size());

        System.out.println(sortDict.getFirst());
        System.out.println(sortDict.getLast());

    }
}
