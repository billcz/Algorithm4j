package org.billcz.common.algorithm.sort;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/30
 */
public class BubbleSorter extends AbstractSorter {
    public static void sort(Comparable[] values) {
        int length = values.length;
        boolean swap = true;

        while (swap) {
            swap = false;
            for (int i = length - 1; i > 0; i--) {
                if (less(values[i], values[i - 1])) {
                    exchange(values, i, i - 1);
                    swap = true;
                }
            }
        }
    }

    public static void sort(Object[] values, Comparator comparator) {
        int length = values.length;
        boolean swap = true;

        while (swap) {
            swap = false;
            for (int i = length - 1; i > 0; i--) {
                if (less(values[i], values[i - 1], comparator)) {
                    exchange(values, i, i - 1);
                    swap = true;
                }
            }
        }
    }

}
