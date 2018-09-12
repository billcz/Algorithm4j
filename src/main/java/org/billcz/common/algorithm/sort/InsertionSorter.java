package org.billcz.common.algorithm.sort;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/30
 */
public class InsertionSorter extends AbstractSorter {
    public static void sort(Comparable[] values) {
        int length = values.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 && less(values[j], values[j - 1]); j--) {
                exchange(values, j, j-1);
            }
        }
    }

    public static void sort(Object[] values, Comparator comparator) {
        int length = values.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 && less(values[j], values[j - 1], comparator); j--) {
                exchange(values, j, j-1);
            }
        }
    }
}
