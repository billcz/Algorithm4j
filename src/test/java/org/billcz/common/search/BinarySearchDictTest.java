package org.billcz.common.search;

import org.billcz.common.algorithm.search.BinarySearchDict;
import org.billcz.common.algorithm.search.Dict;
import org.billcz.common.algorithm.search.SortDict;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/26
 */
public class BinarySearchDictTest {
    public static void main(String[] args) {
        SortDict<Integer, String> binarySearchDict = new BinarySearchDict<Integer, String>();

        for (int i = 0; i < 100; i++) {
            binarySearchDict.put(i, "i" + i);
        }

        System.out.println(binarySearchDict.getFirst());
        System.out.println(binarySearchDict.getLast());

    }
}
