package org.billcz.common.search;

import org.billcz.common.algorithm.search.BinarySearchDict;
import org.billcz.common.algorithm.search.Dict;
import org.billcz.common.algorithm.search.HashDict;
import org.billcz.common.algorithm.search.SortDict;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/26
 */
public class HashDictTest {
    public static void main(String[] args) {
        Dict<Integer, String> hashDict = new HashDict<Integer, String>();

        for (int i = 0; i < 100; i++) {
            hashDict.put(i, "i" + i);
        }

        hashDict.delete(50);
        System.out.println(hashDict.size());
        for (int i = 0; i < 100; i++) {
            System.out.println(hashDict.get(i));
        }
    }
}
