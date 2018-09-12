package org.billcz.common.algorithm.sort;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/29
 */
public class AbstractSorter {
    public static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }

    public static void exchange(Comparable[] values, int i, int j) {
        Comparable swap = values[i];
        values[i] = values[j];
        values[j] = swap;
    }

    public static boolean less(Object a, Object b, Comparator comparator) {
        return (comparator.compare(a, b) < 0);
    }

    public static void exchange(Object[] values, int i, int j) {
        Object swap = values[i];
        values[i] = values[j];
        values[j] = swap;
    }
}
