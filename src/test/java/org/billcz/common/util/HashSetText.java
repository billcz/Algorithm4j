package org.billcz.common.util;

import org.billcz.common.algorithm.util.HashSet;
import org.billcz.common.algorithm.util.Set;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/27
 */
public class HashSetText {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<Integer>();
        Integer[] values = new Integer[] { 1,1,1,1,2,2,2,3};

        for (Integer v : values) {
            hashSet.add(v);
        }


    }
}
