package org.billcz.common.algorithm.sort;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/28
 */
public class SelectionSorter extends AbstractSorter {
    public static void sort(Comparable[] values) {
        int length = values.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(values[j], values[min])) min = j;
            }
            exchange(values, i, min);
        }
    }

    public static void sort(Object[] values, Comparator comparator) {
        int length = values.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(values[j], values[min], comparator)) min = j;
            }
            exchange(values, i, min);
        }
    }
}
